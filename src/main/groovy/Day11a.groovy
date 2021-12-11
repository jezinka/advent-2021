class Day11a {

    static void main(String[] args) {
        List<List<Integer>> board = prepareData('src/main/resources/input11.txt')
        println(process(board, 100))
    }

    public static List prepareData(String path) {
        new File(path).readLines().collect { it.split('').collect { it as Integer } }
    }

    public static Long process(List<List<Integer>> board, Integer steps) {
        Long flashes = 0

        steps.times {
            boolean bang = true
            List tempBoard = board.collect { it.collect { it + 1 } }
            while (bang) {
                bang = false
                for (int i = 0; i < tempBoard.size(); i++) {
                    for (int j = 0; j < tempBoard[i].size(); j++) {
                        if (tempBoard[i][j] > 9) {
                            tempBoard[i][j] = 0
                            flashes++
                            bang = true
                            for (int k = i - 1; k <= i + 1; k++) {
                                for (int l = j - 1; l <= j + 1; l++) {
                                    if (k > -1 && k < board.size() && l > -1 && l < board[k].size()) {
                                        if (tempBoard[k][l] != 0)
                                            tempBoard[k][l] += 1
                                    }
                                }
                            }
                        }
                    }
                }
            }
            board = tempBoard.collect { it.collect { it } }
        }
        return flashes
    }
}
