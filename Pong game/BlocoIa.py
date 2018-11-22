from Bloco import Paddle

window_width = 400
window_height = 300

class AutoPaddle(Paddle):
    def __init__(self, x, w, h, ball, speed):
        super().__init__(x, w, h)
        self.ball = ball
        self.speed = speed

    def move(self):
        if self.ball.dir_x == -1:
            if self.rect.centery < int(window_height / 2):
                self.rect.y += self.speed
            elif self.rect.centery > int(window_height / 2):
                self.rect.y -= self.speed
        elif self.ball.dir_x == 1:
            if self.rect.centery < self.ball.rect.centery:
                self.rect.y += self.speed
            else:
                self.rect.y -= self.speed