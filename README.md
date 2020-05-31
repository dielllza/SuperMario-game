# SuperMario-game
Project for University

The purpose of this project is to use Object Oriented Programming, Graphical User Interfaces and Event Driven Programming in Java to adapt the famous Super Mario game by taking only the main functionality of this game.
The game presents a level that is considered complete when the player reaches 120 points within 60 seconds. The game is built with blocks which can be of three types: 
<ul>
<li>plains,</li>
<li>holes and</li>
<li>towers.</li>
</ul>Plain land is crossed only by walking, while the other two (holes and towers) are obstacles, which appear randomly and must be overcome by jumping. The towers stop the player from moving (he cannot move forward without overcoming them) while if the player falls into the hole he loses the game. Each block passed adds to the player plus one point, thus approaching victory after the previous 120 blocks. So the player can make the choice of the next move based on this set of possible moves:
<ol>
<li>Not to move at all (which does not seem like a good choice, as movement is what brings victory)</li>
<li>Move forward (in the right direction) - user presses right arrow key</li>
<li>Jump vertically - user presses space key</li>
<li>Jump and move forward at the same time (point 2 and point 3 at the same time) - user presses both space and right arrow key at the same time</li>
</ol>
