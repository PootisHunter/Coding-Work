import turtle

def piirra_spiraali(vari, kaaret, A_sade, K_sade, paksuus=1):
    turtle.color(vari)
    turtle.pensize(paksuus)
    turtle.begin_fill()
    for i in range(kaaret):
        turtle.circle(A_sade + K_sade * i, 90)
        turtle.end_fill()

piirra_spiraali("black", 20, 10, 3)
piirra_spiraali("red", 10, 20, 4, 3)
piirra_spiraali("blue", 10, -20, -4, 3)
turtle.done()
