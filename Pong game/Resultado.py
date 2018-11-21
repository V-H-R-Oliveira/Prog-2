import pygame

window_width = 400
window_height = 300
WHITE = (255, 255, 255)
display_surf = pygame.display.set_mode((window_width, window_height))

class Scoreboard():
    def __init__(self, score=0, x=window_width - 150, y=25, font_size=20):
        self.score = score
        self.x = x
        self.y = y
        self.font = pygame.font.Font('freesansbold.ttf', font_size)

    def display(self, score):
        self.score = score
        result_surf = self.font.render('Score = %s' % (self.score), True, WHITE)
        rect = result_surf.get_rect()
        rect.topleft = (self.x, self.y)
        display_surf.blit(result_surf, rect)