class Day1a {

    static void main(String[] args) {

        def f = new File('src/main/resources/input1.txt')
        List<Integer> depths = f.readLines().collect { it as Integer }
        println(process(depths))
    }

    public static int process(List<Integer> depths) {
        int counter = 0
        for (int i = 0; i < depths.size(); i++) {
            def first = depths[i]
            def second = depths[i + 1]
            if (second > first) {
                counter++
            }
        }
        counter
    }
}
