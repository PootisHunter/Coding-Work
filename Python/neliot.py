from turtle import *

def piirra_nelio(sivu, x, y):
    if x > 0:
        c = "blue"
    else :
        c = "red"
    color(c)
    up()
    setx(x)
    sety(y)
    down()
    begin_fill()
    forward(sivu)
    right(90)
    forward(sivu)
    right(90)
    forward(sivu)
    right(90)
    forward(sivu)
    end_fill()
    
    
piirra_nelio(40, -100, 100)
piirra_nelio(60, 100, -100)
piirra_nelio(100, -50, -20)
piirra_nelio(80, 90, 30)
done()