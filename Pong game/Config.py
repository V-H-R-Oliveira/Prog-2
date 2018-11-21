import pygame
from Bloco import Paddle
from Bola import Ball
from BlocoIa import AutoPaddle
from Resultado import Scoreboard

BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
window_width = 400
window_height = 300
display_surf = pygame.display.set_mode((window_width, window_height))

class Game():
    def __init__(self, line_thickness=10, speed=5):
        self.line_thickness = line_thickness
        self.speed = speed
        self.score = 0

        ball_x = int(window_width / 2 - self.line_thickness / 2)
        ball_y = int(window_height / 2 - self.line_thickness / 2)
        self.ball = Ball(ball_x, ball_y, self.line_thickness,
                         self.line_thickness, self.speed)
        self.paddles = {}
        paddle_height = 50
        paddle_width = self.line_thickness
        user_paddle_x = 20
        computer_paddle_x = window_width - paddle_width - 20
        self.paddles['user'] = Paddle(user_paddle_x,
                                      paddle_width, paddle_height)
        self.paddles['computer'] = AutoPaddle(computer_paddle_x,
                                              paddle_width, paddle_height,
                                              self.ball, self.speed)
        self.scoreboard = Scoreboard(0)

    def draw_arena(self):
        display_surf.fill((0, 0, 0))
        pygame.draw.rect(display_surf, WHITE,
                         ((0, 0), (window_width, window_height)),
                         self.line_thickness * 2)
        pygame.draw.line(display_surf, WHITE,
                         (int(window_width / 2), 0),
                         (int(window_width / 2), window_height),
                         int(self.line_thickness / 4))

    def update(self):
        self.ball.move()
        self.paddles['computer'].move()

        if self.ball.hit_paddle(self.paddles['computer']):
            self.ball.bounce('x')
        elif self.ball.hit_paddle(self.paddles['user']):
            self.ball.bounce('x')
            self.score += 1
        elif self.ball.pass_computer():
            self.score += 5
        elif self.ball.pass_player():
            self.score = 0

        self.draw_arena()
        self.ball.draw()
        self.paddles['user'].draw()
        self.paddles['computer'].draw()
        self.scoreboard.display(self.score)