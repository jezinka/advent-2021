class Day8b {

    static void main(String[] args) {
        List<String> positions = prepareData('src/main/resources/input8.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        def input = new File(path).readLines().collect { it.split(/ \| /) }.collect {
            [
                    'digits': it[0].split(' '),
                    'code'  : it[1].split(' ')
            ]
        }
        return input
    }

    public static Long process(List data) {
        def sum = 0
        data.each { d ->

//              11
//            22  33
//              44
//            55  66
//              77

            String codeSum = ''
            Map<String, List<String>> lightsOn = (1..7).collectEntries { [(it): ('a'..'g').toList()] }
            Map<Integer, List<String>> dict = (0..9).collectEntries { [(it): []] }

            dict[8] = d.digits.find { it.size() == 7 }.split('')

            dict[1] = d.digits.find { it.size() == 2 }.split('')
            lightsOn[3] = dict[1].collect { it }
            lightsOn[6] = dict[1].collect { it }

            lightsOn.keySet().each { k ->
                if (k != 3 && k != 6) {
                    lightsOn[k].removeAll(dict[3])
                }
            }

            dict[7] = d.digits.find { it.size() == 3 }.split('')
            lightsOn[1] = dict[7] - dict[1]
            lightsOn.keySet().each { k ->
                if (k != 1) {
                    lightsOn[k].removeAll(lightsOn[1])
                }
            }

            dict[4] = d.digits.find { it.size() == 4 }.split('')
            lightsOn[2] = (dict[4] - dict[1]) as List
            lightsOn[4] = (dict[4] - dict[1]) as List

            def candidates3 = d.digits.findAll { it.size() == 5 }*.split('')
            dict[3] = candidates3.find { dict[7].every { sev -> sev in it } }
            lightsOn[7] = dict[3] - dict[4] - dict[7]
            lightsOn[2] = dict[4] - dict[3]
            lightsOn[4].removeAll(lightsOn[2])

            dict[0] = dict[8] - lightsOn[4]

            lightsOn[5] = dict[8] - dict[3] - dict[4]
            dict[9] = dict[8] - lightsOn[5]

            def candidates5 = d.digits.findAll { it.size() == 5 }*.split('')
            def known5lights = [lightsOn[1], lightsOn[2], lightsOn[4], lightsOn[7]].flatten()
            dict[5] = candidates5.find {
                known5lights.every { sev -> sev in it }
            }
            lightsOn[6] = dict[5] - known5lights

            def candidates2 = d.digits.findAll { it.size() == 5 }*.split('')
            def known2lights = [lightsOn[1], lightsOn[4], lightsOn[5], lightsOn[7]].flatten()
            dict[2] = candidates2.find {
                known2lights.every { sev -> sev in it }
            }
            lightsOn[3] = dict[2] - known2lights

            dict[6] = dict[8] - lightsOn[3]

            d.code.each { code ->
                codeSum += dict.find { it.value.sort().join() == code.split('').sort().join() }.key.toString()
            }
            sum += Long.parseLong(codeSum)
        }
        return sum
    }
}
