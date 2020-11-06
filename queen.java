public class queen extends figure{

    public queen(String color, int player){
        super(color, player);
    }

    @Override
    public boolean canMove(board board, field start, field stop) {
        boolean emptyPath = true;
        if (start.getCoord().get_x() == stop.getCoord().get_x())
        {
            if (start.getCoord().get_y() - stop.getCoord().get_y() > 0)
            {
                for (int i = start.getCoord().get_y(); i > stop.getCoord().get_y(); i--)
                {
                    if (board.boxes[i][start.getCoord().get_x()].getFig() == null)
                    {
                        emptyPath = true;
                    }
                    else
                        {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null)
                {
                    return true;
                }
                else return emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor());
            }
            else if (start.getCoord().get_y() - stop.getCoord().get_y() < 0)
            {
                for (int i = start.getCoord().get_y(); i < stop.getCoord().get_y(); i++)
                {
                    if (board.boxes[i][start.getCoord().get_x()].getFig() == null)
                    {
                        emptyPath = true;
                    }
                    else
                        {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null)
                {
                    return true;
                }
                else return emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor());

            }
        }
        else if (start.getCoord().get_y() == stop.getCoord().get_y())
        {
            if (start.getCoord().get_x() - stop.getCoord().get_x() > 0) {
                for (int i = start.getCoord().get_x(); i > stop.getCoord().get_x(); i--)
                {
                    if (board.boxes[start.getCoord().get_y()][i].getFig() == null)
                    {
                        emptyPath = true;
                    }
                    else
                        {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null) {
                    return true;
                }
                else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor()))
                {
                    return true;
                }
            }
            else if (start.getCoord().get_x() - stop.getCoord().get_x() < 0)
            {
                for (int i = start.getCoord().get_x(); i < stop.getCoord().get_x(); i++)
                {
                    if (board.boxes[start.getCoord().get_y()][i].getFig() == null)
                    {
                        emptyPath = true;
                    } else {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null)
                {
                    return true;
                }
                else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor()))
                {
                    return true;
                }

            }
            // bishop like behavior
            else if (stop.getCoord().get_x() - start.getCoord().get_x() > 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() > 0)
            {
                // +x +y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++)
                {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++)
                    {
                        if (i == j)
                        {
                            if (board.boxes[start.getCoord().get_y() + j][start.getCoord().get_x() + i].getFig() == null)
                            {
                                emptyPath = true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }

            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() > 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() < 0)
            {
                // +x -y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++)
                {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++)
                    {
                        if (Math.abs(i) == Math.abs(j))
                        {
                            if (board.boxes[start.getCoord().get_y() - j][start.getCoord().get_x() + i].getFig() == null)
                            {
                                emptyPath = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() < 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() < 0)
            {
                // -x -y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++)
                {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++)
                    {
                        if (Math.abs(i) == Math.abs(j))
                        {
                            if (board.boxes[start.getCoord().get_y() - j][start.getCoord().get_x() - i].getFig() == null)
                            {
                                emptyPath = true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() < 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() > 0)
            {
                // -x +y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++)
                {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++)
                    {
                        if (Math.abs(i) == Math.abs(j)) {
                            if (board.boxes[start.getCoord().get_y() + j][start.getCoord().get_x() - i].getFig() == null)
                            {
                                emptyPath = true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
            }

            // if path is empty check whether stop position is eiter empty or occupied by a figure of opposite color
            if (emptyPath)
            {
                if (board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null)
                {
                    return true;
                }
                else return !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().equals(
                        board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor());
            }
        }
        else
        {
            return false;
        }

        return false;
    }
}

