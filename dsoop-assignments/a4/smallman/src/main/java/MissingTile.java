public class MissingTile {
  public static void tileGrid(Grid board) {
    tilingHelper(board,board.size(), board.getPaintedCellX(), board.getPaintedCellY(), 0, 0);
  }

  public static void tilingHelper(Grid board, int board_size, int paintedX, int paintedY, int topX, int topY) {
    int orient=0;

    if (paintedX >= topX + (board_size / 2) && paintedY >= topY + (board_size / 2)) orient=1;
    if (paintedX >= topX + (board_size / 2) && paintedY < topY + (board_size / 2)) orient=0;
    if (paintedX < topX + (board_size / 2) && paintedY >= topY + (board_size / 2)) orient=2;
    if (paintedX < topX + (board_size / 2) && paintedY < topY + (board_size / 2)) orient=3;

    if (board_size==2){
      board.setTile(paintedX,paintedY,orient);
    }

    else {
      if (orient==1) { //o==1
        board.setTile(topX+board_size / 2, topY+board_size / 2, 1);
        tilingHelper(board,board_size/2,topX + board_size / 2 - 1, topY + board_size / 2 - 1, topX, topY);//top left
        tilingHelper(board,board_size/2, topX + board_size / 2 - 1, topY + board_size / 2, topX, topY + board_size / 2);//bot left
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2 - 1, topX + board_size / 2, topY);//top right
        tilingHelper(board,board_size/2, paintedX, paintedY, topX + board_size / 2, topY + board_size / 2);//bot right//change
      }
      if (orient==0) { //o==0
        board.setTile(topX+board_size / 2, topY+board_size / 2-1, 0);
        tilingHelper(board,board_size/2, topX + board_size / 2 - 1, topY + board_size / 2 - 1, topX, topY);
        tilingHelper(board, board_size/2,topX + board_size / 2 - 1, topY + board_size / 2, topX, topY + board_size / 2);
        tilingHelper(board,board_size/2, paintedX, paintedY, topX + board_size / 2, topY);//change
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2, topX + board_size / 2, topY + board_size / 2);

      }
      if (orient==2) { //o==2
        board.setTile(topX+board_size / 2-1, topY+board_size / 2, 2);
        tilingHelper(board,board_size/2, topX + board_size / 2 - 1, topY + board_size / 2 - 1, topX, topY);
        tilingHelper(board, board_size/2,paintedX, paintedY, topX, topY + board_size / 2);//change
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2 - 1, topX + board_size / 2, topY);
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2, topX + board_size / 2, topY + board_size / 2);

      }
      if (orient==3) { //o==3
        board.setTile(topX+board_size / 2-1, topY+board_size / 2-1, 3);
        tilingHelper(board,board_size/2, paintedX, paintedY, topX, topY);//change
        tilingHelper(board,board_size/2, topX + board_size / 2 - 1, topY + board_size / 2, topX, topY + board_size / 2);
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2 - 1, topX + board_size / 2, topY);
        tilingHelper(board,board_size/2, topX + board_size / 2, topY + board_size / 2, topX + board_size / 2, topY + board_size / 2);

      }
    }
  }
}
