import pygame

window_width = 400
window_height = 300
WHITE = (255, 255, 255)
display_surf = pygame.display.set_mode((window_width, window_height))

class Paddle(pygame.sprite.Sprite):
    def __init__(self, x, w, h):
        self.x = x
        self.w = w
        self.h = h
        self.y = int(window_height / 2 - self.h / 2)
        self.rect = pygame.Rect(self.x, self.y, self.w, self.h)

    def draw(self):
        if self.rect.bottom > window_height - self.w:
            self.rect.bottom = window_height - self.w
        elif self.rect.top < self.w:
            self.rect.top = self.w
        pygame.draw.rect(display_surf, WHITE, self.rect)

    def move(self, pos):
        self.rect.y = pos[1]