package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {
    private var nun1: Double = 0.0
    private var nun2: Double = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadoTextView.text= "0"
        operacion = NO_OPERACION

        unoBoton.setOnClickListener {numeroPresionado("1")}
        dosBoton.setOnClickListener { numeroPresionado("2") }
        tresBoton.setOnClickListener { numeroPresionado("3") }
        cuatroBoton.setOnClickListener { numeroPresionado("4") }
        cincoBoton.setOnClickListener { numeroPresionado("5") }
        seisBoton.setOnClickListener { numeroPresionado("6") }
        sieteBoton.setOnClickListener { numeroPresionado("7") }
        ochoBoton.setOnClickListener { numeroPresionado("8") }
        nueveBoton.setOnClickListener { numeroPresionado("9") }
        ceroBoton.setOnClickListener { numeroPresionado("0") }
        comaBoton.setOnClickListener { numeroPresionado("." ) }

        borrarBoton.setOnClickListener {reseteartodo() }

        sumarBoton.setOnClickListener {operacionPresionada(SUMA)}
        restaBoton.setOnClickListener {operacionPresionada(Resta)}
        multiplicarBoton.setOnClickListener {operacionPresionada(MULTIPLICACION)}
        divisionBoton.setOnClickListener {operacionPresionada(Division)}

        igualBoton.setOnClickListener { resolverpresionado() }

        borrarBoton.setOnClickListener{
            nun1 = 0.0
            nun2 = 0.0
            resultadoTextView.text ="0"
            operacion = NO_OPERACION

        }

        igualBoton.setOnClickListener {
        val resultado = when(operacion){
            SUMA -> nun1 + nun2
            Resta -> nun1 - nun2
            MULTIPLICACION -> nun1 * nun2
            Division -> nun1 / nun2
            else -> 0
        }
            resultadoTextView.text = resultado.toString()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun numeroPresionado(num:String){

        if(resultadoTextView.text == "0" && num != "." ){
            resultadoTextView.text = num
        } else {
            resultadoTextView.text = "${resultadoTextView.text}$num"
        }

      //resultadoTextView.text = "${resultadoTextView.text}$digito"

        if (operacion == NO_OPERACION){

            nun1 = resultadoTextView.text.toString().toDouble()

        } else {
            nun2 = resultadoTextView.text.toString().toDouble()
        }

    }

    private fun operacionPresionada(operacion: Int){

        this.operacion = operacion

        nun1 = resultadoTextView.text.toString().toDouble()

        resultadoTextView.text = "0"

    }
    private fun resolverpresionado(){

        val resultado = when(operacion){
            SUMA -> nun1 + nun2
            Resta -> nun1 - nun2
            MULTIPLICACION -> nun1 * nun2
            Division -> nun1 / nun2
            else -> 0
        }
        nun1 = resultado as Double

        resultadoTextView.text = if ("$resultado".endsWith(".0")) {"$resultado".replace(".0","") }
        else {"%.2f".format(resultado) }
    }

    private fun reseteartodo(){
        resultadoTextView.text = "0"
        nun1 = 0.0
        nun2 = 0.0

    }

    companion object{
        const val SUMA = 1
        const val Resta = 2
        const val MULTIPLICACION = 3
        const val Division = 4
        const val NO_OPERACION = 0

    }




}



