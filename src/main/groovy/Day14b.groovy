class Day14b {

    static void main(String[] args) {
        Map instructions = Day14a.prepareData('src/main/resources/input14.txt')
        println(process(instructions, 40))
    }

    public static Long process(Map instructions, Integer steps) {
        String template = instructions.template
        Map<String, String> rules = instructions.rules

        Map<String, Long> pairs = [:]
        for (int i = 0; i < template.length() - 1; i++) {
            String pair = template[i..i + 1]
            if (pairs.containsKey(pair)) {
                pairs[pair]++
            } else {
                pairs.put(pair, 1L)
            }
        }

        steps.times {
            Map<String, Long> newPairs = [:]
            pairs.each { String k, Long v ->
                List newTemplateList = k.split('').toList()
                String newTemplate = newTemplateList[0] + rules[k] + newTemplateList[1]
                for (int i = 0; i < newTemplate.length() - 1; i++) {
                    String pair = newTemplate[i..i + 1]
                    if (newPairs.containsKey(pair)) {
                        newPairs[pair] += v
                    } else {
                        newPairs.put(pair, v)
                    }
                }
            }
            pairs = newPairs.clone()
        }

        Map<String, Long> charactersOccurrence = [:]
        pairs.each { k, v ->
            k.split('').each { c ->
                if (charactersOccurrence.containsKey(c)) {
                    charactersOccurrence[c] += v
                } else {
                    charactersOccurrence.put(c, v)
                }
            }
        }
        List<Double> counters = charactersOccurrence.values().collect { Math.ceil(it / 2) }
        return counters.max() - counters.min()
    }
}
