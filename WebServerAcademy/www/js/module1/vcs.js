window.onload = function() {
    var s = Snap("#svg-cvcs");
    console.log(s);

    var c1t = s.text(136, 281, 'client');
    var c2t = s.text(267, 281, 'client');
    var c3t = s.text(395, 281, 'client');
    var ctext = [c1t, c2t, c3t];
    var ct = s.g(c1t, c2t, c3t);
    var defStyle = {
        text: 'client',
        fill: '#fff',
        fontSize: 32,
    };
    ct.attr(defStyle);
    var commitStyle = {
        text: 'commit',
        fill: '#fff',
        fontSize: 25
    };
    var updateStyle = {
        text: 'update',
        fill: '#fff',
        fontSize: 25
    };

    var bAnim = [{
        transform: 't73,-100'
    }, {
        transform: 't0,-95'
    }, {
        transform: 't-77,-95'
    }];

    Snap.load("/svg/cvcs_diag.svg", function(f) {

        var c1 = f.select("#c1_icon");
        var b1 = f.select("#ball1"),
            b1x = b1.getBBox().cx,
            b1y = b1.getBBox().cy;
        var b2 = f.select("#ball2"),
            b2x = b2.getBBox().cx,
            b2y = b2.getBBox().cy;
        var b3 = f.select("#ball3"),
            b3x = b3.getBBox().cx,
            b3y = b3.getBBox().cy;

        var balls = [b1, b2, b3];

        commit();

        var CommitCounter = function() {
            var counter = 0;

            var count = function() {
                counter++;
                if (counter == 2) {
                    counter = 0;
                    commit();
                }
            };
            return count;
        };

        function commit() {
        	ctext.forEach(function(element) {
        		element.attr(defStyle);
        	});
            var randomBall = getRandomArbitrary(0, 2);
            balls[randomBall].transform('t0,0');
            ctext[randomBall].attr(commitStyle);
            balls[randomBall].animate(
                bAnim[randomBall], 3000, mina.easeout, function() {
                    update(randomBall);
                }
            );
        }

        function update(commiter) {
            ctext[commiter].attr(defStyle);
            var ccounter = CommitCounter();

            balls.forEach(function(element, index) {
                if (index != commiter) {
                    ctext[index].attr(updateStyle);
                    element.attr(bAnim[index]);
                    element.animate({
                        transform: 't0,0'
                    }, 3000, mina.easeout, ccounter);
                }
            });
        }
        s.append(f);
    });
};



function getRandomArbitrary(min, max) {
    return Math.round(Math.random() * (max - min) + min);
}