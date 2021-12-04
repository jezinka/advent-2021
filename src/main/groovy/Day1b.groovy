class Day1b {

    static void main(String[] args) {

        def f = new File('src/main/resources/input1.txt')
        List<Integer> depths = f.readLines().collect { it as Integer }
        println(processWindow(depths))
    }

    public static int processWindow(List<Integer> depths) {
        int counter = 0
        for (int i = 0; i < depths.size()-3; i++) {
            def first = depths[i..i+2].sum()
            def second = depths[i+1..i+3].sum()
            if (second > first) {
                counter++
            }
        }
        counter
    }
}
