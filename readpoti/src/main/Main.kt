import wiringPi.*
import kotlinx.cinterop.*

// https://tutorials-raspberrypi.de/wiringpi-installieren-pinbelegung/
// http://wiringpi.com/reference/core-functions/

val POTI = 2

//IDE main file
fun main(args: Array<String>) {
    println("Hello, Native World!")
    for (a in 1..10)
        print("${a} ")

    Greeter("Martin").greet()

    println("Now start read buton forever ...")
    Poti(800).read()
}



class Poti(val tempo: Int){
    fun read() {
        print("..starup do init..")
        wiringPiSetup()
        pullUpDnControl (POTI, PUD_OFF)
        pinMode(POTI, INPUT)

        // start charging
        pinMode(POTI, OUTPUT)
        digitalWrite(POTI, HIGH)
        print("..charge Cap..")
        delay(1000)

        // now discharging and messure the time
        print("..now start discharging..")

        pullUpDnControl (POTI, PUD_OFF)
        pinMode(POTI, INPUT)

      
        var x = 0
        while(digitalRead(POTI) > 0) {

            print(".")
            x++

        }
        print("RESULT:")
        println(x)
    }
}

class Greeter(val name: String) {
    fun greet() {
        println("Hello, ${name}");
    }
}
