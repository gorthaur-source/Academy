var wfconfig = {

    active: function() {
        console.log("font loaded");
        init();
    },

    google: {
        families: ['Open+Sans:400,700,400italic,700italic']
    }

};

WebFont.load(wfconfig);
var game;

var init = function() {

    game = new Phaser.Game(300, 600, Phaser.AUTO, 'memory-diagram', {
        preload: preload,
        create: create
    }, true);
    var textToDisplay = 'Rui F.';

    function preload() {}

    var mask;
    var memoryDiagram;

    function create() {

        createMemory();
        createMask();
        game.input.addMoveCallback(move, this);
    }

    function move(pointer, x, y) {
        mask.x = x;
        mask.y = y;
    }

    function createMemory() {
        var memoryMaker = MemoryMaker();
        memoryDiagram = memoryMaker.makeCells(asciibin(textToDisplay, 'ascii'), ["11110101", "01011101", "10110110"]);
        memoryDiagram.x = 200;
        memoryDiagram.y = 50;
    }

    function createMask() {
        //  A mask is a Graphics object
        mask = game.add.group();
        var maskLayer = game.add.graphics(0, 0);
        maskLayer.beginFill(0xffffff);
        maskLayer.drawCircle(0, 0, 100);
        memoryDiagram.getTop().mask = maskLayer;
        mask.add(maskLayer);

        var maskBorder = game.add.graphics(0, 0);
        maskBorder.lineStyle(4, 0xFF0000, 0.5);
        maskBorder.drawCircle(0, 0, 100);
        mask.add(maskBorder);

        var style = {
            font: "22px Open Sans",
            fill: '#FFFFFF'
        };
        var maskText = game.add.text(0, maskBorder.y + 40, 'ASCII X-RAY', style);
        maskText.anchor.set(0.5);
        maskText.alpha = 0.8;
        mask.add(maskText);
    }
};