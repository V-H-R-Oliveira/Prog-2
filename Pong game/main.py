import pygame, sys
from pygame.locals import *
from Config import Game

window_width = 400
window_height = 300

display_surf = pygame.display.set_mode((window_width, window_height))

tickrate = pygame.time.Clock()

def main():
    pygame.init()
    pygame.display.set_caption('The Pong Game')
    pygame.mouse.set_visible(0)

    game = Game(speed=4)

    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == MOUSEMOTION:
                game.paddles['user'].move(event.pos)

        game.update()
        pygame.display.update()
        tickrate.tick(40)

if __name__ == '__main__':
    main()