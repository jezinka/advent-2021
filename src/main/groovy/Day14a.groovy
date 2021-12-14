class Day14a {

    static void main(String[] args) {
        Map instructions = prepareData('src/main/resources/input14.txt')
        println(process(instructions))
    }

    public static Map prepareData(String path) {
        List<String> l = new File(path).readLines()
        Map<String, String> rules = [:]
        for (line in l[2..-1]) {
            String[] rule = line.split(' -> ')
            rules.put(rule[0], rule[1])
        }

        return [rules: rules, template: l[0]]
    }

    public static Long process(Map instructions) {
        String template = instructions.template

        10.times {
            List addidtionalChars = []
            for (int i = 0; i < template.length() - 1; i++) {
                String pair = template[i..i + 1]
                addidtionalChars += instructions.rules[pair]
            }
            List<String> tmpTemplate = template.collect { it }
            template = ''
            while (tmpTemplate) {
                template += tmpTemplate.pop()
                template += addidtionalChars ? addidtionalChars.pop() : ''
            }
        }
        List<Long> counters = template.split('').countBy { it }*.value
        return counters.max() - counters.min()
    }
}
