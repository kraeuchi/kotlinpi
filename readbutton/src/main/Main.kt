import wiringPi.*
import kotlinx.cinterop.*

// https://tutorials-raspberrypi.de/wiringpi-installieren-pinbelegung/

val BUTTON = 2

//IDE main file
fun main(args: Array<String>) {
    println("Hello, Native World!")
    for (a in 1..10)
        print("${a} ")

    Greeter("Martin").greet()

    println("Now start read buton forever ...")
    Button(800).read()
}



class Button(val tempo: Int){
    fun read() {
        wiringPiSetup()
        pullUpDnControl (BUTTON, PUD_DOWN)
        pinMode(BUTTON, INPUT)

        while(true) {
            val res = digitalRead(BUTTON)
            print(res)
            print("..")

            delay(tempo)
        }
    }
}

class Greeter(val name: String) {
    fun greet() {
        println("Hello, ${name}");
    }
}
