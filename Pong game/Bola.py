import pygame

window_width = 400
window_height = 300
WHITE = (255, 255, 255)
display_surf = pygame.display.set_mode((window_width, window_height))

class Ball(pygame.sprite.Sprite):
    def __init__(self, x, y, w, h, speed):
        self.x = x
        self.y = y
        self.w = w
        self.h = h
        self.speed = speed
        self.dir_x = -1
        self.dir_y = -1

        self.rect = pygame.Rect(self.x, self.y, self.w, self.h)

    def draw(self):
        pygame.draw.rect(display_surf, WHITE, self.rect)

    def move(self):
        self.rect.x += (self.dir_x * self.speed)
        self.rect.y += (self.dir_y * self.speed)

        if self.hit_ceiling() or self.hit_floor():
            self.bounce('y')
        if self.hit_wall():
            self.bounce('x')

    def bounce(self, axis):
        if axis == 'x':
            self.dir_x *= -1
        elif axis == 'y':
            self.dir_y *= -1

    def hit_paddle(self, paddle):
        if pygame.sprite.collide_rect(self, paddle):
            return True
        else:
            return False

    def hit_wall(self):
        if ((self.dir_x == -1 and self.rect.left <= self.w) or
                (self.dir_x == 1 and self.rect.right >= window_width - self.w)):
            return True
        else:
            return False

    def hit_ceiling(self):
        if self.dir_y == -1 and self.rect.top <= self.w:
            return True
        else:
            return False

    def hit_floor(self):
        if self.dir_y == 1 and self.rect.bottom >= window_height - self.w:
            return True
        else:
            return False

    def pass_player(self):
        if self.rect.left <= self.w:
            return True
        else:
            return False

    def pass_computer(self):
        if self.rect.right >= window_width - self.w:
            return True
        else:
            return False
