class Day4b {

    static void main(String[] args) {
        List inputData = []
        List boards = []
        prepareData('src/main/resources/input4.txt', inputData, boards)
        println(inputData)
        println(boards)
        println(process(inputData, boards))
    }

    public static void prepareData(String path, List inputData, List boards) {
        def f = new File(path)
        List data = f.readLines()
        inputData.addAll(data[0].split(',').collect { it as Integer })
        List board = []
        for (int i = 2; i < data.size(); i++) {

            if (data[i].trim() == '') {
                boards << board.collect { it }
                board = []

            } else {
                board << data[i].split(' ').findAll().collect { it as Integer }
            }
        }
        boards << board.collect { it }
    }

    public static Long process(List input, List<List> boards) {
        Long sum = 0
        for (number in input) {
            List winBoards = []
            for (board in boards) {
                board.each { row ->
                    row.eachWithIndex { entry, idx ->
                        if (entry == number)
                            row[idx] = null
                    }
                }
                if (bingo(board)) {
                    sum = board.flatten().findAll { it }.sum() * number
                    winBoards.add(board)
                }
            }
            boards.removeAll(winBoards)
        }
        return sum
    }

    private static boolean bingo(List board) {
        boolean isBingo = false
        board.each { row ->
            isBingo = row.every { it == null } || isBingo
        }

        for (int i = 0; i < board.size(); i++) {
            isBingo = board*.get(i).every { it == null } || isBingo
        }

        return isBingo
    }
}
