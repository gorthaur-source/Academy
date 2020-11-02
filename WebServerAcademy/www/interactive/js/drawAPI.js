var MemoryMaker = function(start_index,mode) {
    var CELL_WIDTH = 128;
    var CELL_HEIGHT = 32;
    var SEPARATOR_HEIGHT = 60;

    var memory = game.make.group();
    var binLayer = game.make.group();
    var asciiLayer = game.make.group();
    var axisSubtitles = game.make.group();
    memory.add(binLayer);
    memory.add(axisSubtitles);
    memory.add(asciiLayer);
    var current_y = CELL_HEIGHT / 2;

    var boxFactory = BoxFactory();
    if (!start_index) {
        start_index = 0;
    }

    function makeCell(height) {
        var cell = boxFactory.makeBox(0, current_y, CELL_WIDTH, height);
        return cell;
    }

    function insertReference(index, cell) {
        var style = {
            font: "16px Open Sans",
            fill: '#FFFFFF'
        };
        var hex_string = index.toString(16).toUpperCase();
        var hex_tmp = hex_string;
        for (var i = 0; i < 4 - hex_tmp.length; i++) {
            hex_string = "0" + hex_string;
        }
        var ref_str = "0x" + hex_string;
        var reference = game.add.text(0, 0, ref_str, style);
        reference.x = -cell.width / 2 - 10;
        reference.anchor.x = 1;
        reference.anchor.y = 0.4;

        cell.addChild(reference);
        return reference;
    }

    function showSubtitles() {
        var style = {
            font: "18px Open Sans",
            fill: '#FFFFFF'
        };
        var legendtext = game.add.text(-memory.width / 2 - 90, memory.height / 2, 'Memory Address', style, axisSubtitles);
        legendtext.anchor.set(0.5);
        legendtext.rotation = -(Math.PI / 2);
    }

    function addTail(tailData) {
        if (mode == 'modeMartelo') {
            newData = ['ADD','MOVE','COPY'];
        }
        var textFactory = TextFactory();

        current_y += SEPARATOR_HEIGHT / 2 - CELL_HEIGHT / 2;
        var binsep = binLayer.add(separatorCell = makeCell(SEPARATOR_HEIGHT));
        var asciisep = asciiLayer.add(separatorCell = makeCell(SEPARATOR_HEIGHT));
        current_y += SEPARATOR_HEIGHT - CELL_HEIGHT / 2;
        textFactory.insertTextOnObject(binsep, '. . .', 'center');
        textFactory.insertTextOnObject(asciisep, '. . .', 'center');

        for (var c = 0; c < tailData.length; c++) {
            var binCell = makeCell(CELL_HEIGHT);
            binLayer.add(binCell);
            var asciiCell = makeCell(CELL_HEIGHT);
            asciiLayer.add(asciiCell);

            insertReference((65536 - tailData.length) + c, binCell);
            textFactory.insertTextOnObject(binCell, tailData[c], 'center');
            if (mode == 'modeMartelo') {
                textFactory.insertTextOnObject(asciiCell, newData[c], 'center');
            } else {
                textFactory.insertTextOnObject(asciiCell, asciibin(tailData[c], 'binary'), 'center');
            }
            current_y += CELL_HEIGHT;
        }
    }

    var options = {
        makeCells: function(data, tailData, firstAddress) {
            if (mode == 'modeMartelo') {
                newData = ['UNKNOWN','SUBTRACT','UNKNOWN','UNKNOWN','UNKNOWN','DIVIDE'];
            }
            var textFactory = TextFactory();
            for (var i = 0; i < data.length; i++) {

                var binCell = makeCell(CELL_HEIGHT);
                binLayer.add(binCell);
                var asciiCell = makeCell(CELL_HEIGHT);
                asciiLayer.add(asciiCell);

                insertReference(start_index + i, binCell);

                if (data) {
                    var binText = textFactory.insertTextOnObject(binCell, data[i], 'center');
                    if (mode == 'modeMartelo') {
                        var asciiText = textFactory.insertTextOnObject(asciiCell, newData[i], 'center');
                    } else {
                        var asciiText = textFactory.insertTextOnObject(asciiCell, asciibin(data[i], 'binary'), 'center');
                    }
                }
                current_y += CELL_HEIGHT;
            }
            addTail(tailData);
            showSubtitles();
            return memory;
        }
    };

    return options;
};

var LineFactory = function() {

    var strokeSize = 1.5;
    var alpha = 1;
    var color = 0xFFFFFF;

    function buildLine(x1, y1, x2, y2) {
        var line = game.make.graphics(0, 0);
        line.lineStyle(strokeSize, color, alpha);
        line.moveTo(x1, y1);
        line.lineTo(x2, y2);

        var leftX = (x2 > 0 ? x1 : x2);
        var topY = (y2 > 0 ? y1 : y2);
        var linesprite = game.add.sprite(leftX, topY, line.generateTexture());

        return linesprite;
    }

    var options = {
        //returns a line from x1,y1 to x2,y2
        makeLine: function(x1, y1, x2, y2) {
            return buildLine(x1, y1, x2, y2);
        },
        //returns a line from x,y to dx, dy (deltas)
        makeLineD: function(x, y, dx, dy) {
            var x2 = x + dx;
            var y2 = y + dy;
            return buildLine(x, y, x2, y2);
        },
        //duplicates a line n times, in the chosen direction (up,down,left,right)
        multiply: function(line, direction, n, spacing) {
            var x = 0;
            var y = 0;
            var multipleLines = game.add.group();

            if (!spacing) {
                spacing = 4;
            }

            for (var i = 0; i < n - 1; i++) {
                if (direction == 'up') {
                    y -= spacing;
                } else if (direction == 'down') {
                    y += spacing;
                } else if (direction == 'left') {
                    x -= spacing;
                } else if (direction == 'right') {
                    x += spacing;
                }
                var dupLine = game.make.sprite(x, y, line.generateTexture());
                line.addChild(dupLine);
            }
            return line;
        },
        //sets stroke size in pixels
        setStrokeSize: function(size) {
            strokeSize = size;
        },
        //set opacity from 0 (invisbile) to 1 (opaque)
        setAlpha: function(_alpha) {
            alpha = _alpha;
        },
        //set color (hexadecimal value)
        setColor: function(_color) {
            color = _color;
        }
    }
    return options;
};

var BoxFactory = function() {
    var color = 0x000000;
    var borderColor = 0xFF0000;
    var alpha = 1;
    var borderAlpha = 1;
    var borderStrokeSize = 2;

    var options = {
        //makes a rectangle box with it's center localized at x,y
        makeBox: function(x, y, width, height) {
            var box = game.make.graphics(0, 0);
            box.lineStyle(borderStrokeSize, borderColor, borderAlpha);
            box.beginFill(color, alpha);
            box.drawRect(0, 0, width, height);
            box.endFill();

            var boxSprite = game.add.sprite(x, y, box.generateTexture());
            boxSprite.anchor.set(0.5);
            return boxSprite;
        },
        //sets opacity of the box's fill (0 transparent, 1 opaque)
        setFillAlpha: function(_alpha) {
            alpha = _alpha;
        },
        //sets opacity of the box's border (0 trnasparent, 1 opaque)
        setBorderAlpha: function(_alpha) {
            borderAlpha = _alpha;
        },
        //sets border stroke size
        setBorderStrokeSize: function(size) {
            borderStrokeSize = size;
        },
        //sets fill color (hexadecimal value)
        setFillColor: function(_color) {
            color = _color;
        },
        //sets border color (hexadecimal value)
        setBorderColor: function(_color) {
            borderColor = _color;
        }
    }

    return options;
};

var CircleFactory = function() {
    var color = 0x000000;
    var borderColor = 0xFF0000;
    var alpha = 1;
    var borderAlpha = 1;
    var borderStrokeSize = 2;

    var options = {
        //makes a circle with it's center localized at x,y
        makeCircle: function(x, y, radius) {
            var circle = game.make.graphics(0, 0);
            circle.lineStyle(borderStrokeSize, borderColor, borderAlpha);
            circle.beginFill(color, alpha);
            circle.drawCircle(0, 0, radius);

            var circleSprite = game.add.sprite(x, y, circle.generateTexture());
            circleSprite.anchor.set(0.5);
            return circleSprite;
        },
        //sets opacity of the box's fill (0 transparent, 1 opaque)
        setFillAlpha: function(_alpha) {
            alpha = _alpha;
        },
        //sets opacity of the box's border (0 trnasparent, 1 opaque)
        setBorderAlpha: function(_alpha) {
            borderAlpha = _alpha;
        },
        //sets border stroke size
        setBorderStrokeSize: function(size) {
            borderStrokeSize = size;
        },
        //sets fill color (hexadecimal value)
        setFillColor: function(_color) {
            color = _color;
        },
        //sets border color (hexadecimal value)
        setBorderColor: function(_color) {
            borderColor = _color;
        }
    }

    return options;
};

var TextFactory = function() {

    var style = {
        font: "18px Open Sans",
        fill: '#FFFFFF',
        stroke: 'black',
        strokeThickness: 0
    };

    var options = {
        //makes a sprite from text, centered in x,y 
        makeText: function(str, x, y) {
            var str = game.add.text(x, y, str, style);
            str.anchor.set(0.5);

            return str;
        },
        //inserts text inside a circle or a box
        insertTextOnObject: function(object, string, pos) {
            var x = 0;
            var y = 1 / 2;
            var str = game.make.text(x, y, string, style);

            if (pos == 'top') {
                str.y = -object.height / 2 + str.height;
            }

            str.anchor.x = 0.5;
            str.anchor.y = 0.45;
            object.addChild(str);
        },
        //sets text style. style is an object (check phaser docs)
        setStyle: function(_style) {
            style = _style;
        },
        //set strokesize
        setStrokeSize: function(size) {
            style.strokeThickness = size;
        },
        //set stroke color
        setStrokeColor: function(_color) {
            style.stroke = _color;
            console.log(style);
        },
        getDefaultStyle: function() {
            return {
                font: "18px Open Sans",
                fill: '#FFFFFF',
                stroke: 'black',
                strokeThickness: 0
            }
        }
    };
    return options;
}

var TweenFactory = function() {


    var options = {
        //moves sprite to x,y in t ms
        moveTo: function(sprite, x, y, t) {
            var tween;
            var duration = t;

            if (tween && tween.isRunning) {
                tween.stop();
            }

            tween = game.add.tween(sprite).to({
                x: x,
                y: y
            }, duration, Phaser.Easing.Linear.None, true);

            return tween;
        }
    }
    return options;
}