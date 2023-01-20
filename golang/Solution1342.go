package main

func numberOfSteps(num int) int {
    var step int
    for {
        if num == 0 {
            return step
        }
        step ++
        if num % 2 ==0 {
            num /=2
        } else {
            num --
        }
    }
}
