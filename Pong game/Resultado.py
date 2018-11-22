import pygame

window_width = 400
window_height = 300
WHITE = (255, 255, 255)
display_surf = pygame.display.set_mode((window_width, window_height))

class Scoreboard():
    def __init__(self, score=0, x=window_width - 150, y=25, font_size=20):
        self.score = score
        self.__x = x
        self.__y = y
        self.font = pygame.font.Font('freesansbold.ttf', font_size)

    def getX(self):
        return self.__x

    def setX(self, x):
        self.__x = x

    def getY(self):
        return self.__y

    def setY(self, y):
        self.__y = y

    def display(self, score):
        self.score = score
        result_surf = self.font.render('Score = %s' % (self.score), True, WHITE)
        rect = result_surf.get_rect()
        rect.topleft = (self.getX(), self.getY())
        display_surf.blit(result_surf, rect)