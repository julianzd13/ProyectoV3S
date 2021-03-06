package com.example.projectV3S

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.projectV3S.Room.NewResRoom
import com.example.projectV3S.Room.NewresDAO
import com.example.projectV3S.UTILS.Constantes
import com.example.projectV3S.model.Reservas
import com.example.projectV3S.model.ReservasLocal
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_reserva_step3.*

class NewReservaStep3 : AppCompatActivity() {

    var flag: Int = 0
    var num_particif1 : String = Constantes.EMPTY

    var escenario : String = Constantes.EMPTY
    var fecha : String = Constantes.EMPTY
    var hora : String = Constantes.EMPTY

    var partici_1 : String = Constantes.EMPTY
    var partici_2 : String = Constantes.EMPTY
    var partici_3 : String = Constantes.EMPTY
    var partici_4 : String = Constantes.EMPTY
    var partici_5 : String = Constantes.EMPTY
    var partici_6 : String = Constantes.EMPTY
    var partici_7 : String = Constantes.EMPTY
    var partici_8 : String = Constantes.EMPTY
    var partici_9 : String = Constantes.EMPTY
    var partici_10 : String = Constantes.EMPTY
    var partici_11 : String = Constantes.EMPTY
    var partici_12 : String = Constantes.EMPTY
    var partici_13 : String = Constantes.EMPTY
    var partici_14 : String = Constantes.EMPTY
    var partici_15 : String = Constantes.EMPTY
    var partici_16 : String = Constantes.EMPTY


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reserva_step3)

        var dataf1 = intent?.extras
        num_particif1 = dataf1!!.getString("Numpartici").toString()

        CargardatosfromRoom()

        bt_conti_to_main.setOnClickListener {
            flag = 0
            Guardar_Newreser_Firebase()
        }

    }


    private fun CargardatosfromRoom() {
        val newresDAO: NewresDAO = NewResRoom.database1.NewresDAO()
        val nuevaReservRoom = newresDAO.searchEscenari()

        escenario= nuevaReservRoom.escen.toString()
        tv_escen.text = escenario
        fecha = nuevaReservRoom.fecha.toString()
        tv_fech.text = fecha
        hora = nuevaReservRoom.hora.toString()
        tv_hor.text = hora

        partici_1 = nuevaReservRoom.participante1.toString()
        partici_2 = nuevaReservRoom.participante2.toString()
        partici_3 = nuevaReservRoom.participante3.toString()
        partici_4 = nuevaReservRoom.participante4.toString()
        partici_5 = nuevaReservRoom.participante5.toString()
        partici_6 = nuevaReservRoom.participante6.toString()
        partici_7 = nuevaReservRoom.participante7.toString()
        partici_8 = nuevaReservRoom.participante8.toString()
        partici_9 = nuevaReservRoom.participante9.toString()
        partici_10 = nuevaReservRoom.participante10.toString()
        partici_11 = nuevaReservRoom.participante11.toString()
        partici_12 = nuevaReservRoom.participante12.toString()
        partici_13 = nuevaReservRoom.participante13.toString()
        partici_14 = nuevaReservRoom.participante14.toString()
        partici_15 = nuevaReservRoom.participante15.toString()
        partici_16 = nuevaReservRoom.participante16.toString()



        tv_part1.text = partici_1
        tv_part2.text = partici_2
        tv_part3.text = partici_2
        tv_part4.text = partici_2
        tv_part5.text = partici_2
        tv_part6.text = partici_2
        tv_part7.text = partici_2
        tv_part8.text = partici_2
        tv_part9.text = partici_2
        tv_part10.text = partici_2
        tv_part11.text = partici_2
        tv_part12.text = partici_2
        tv_part13.text = partici_2
        tv_part14.text = partici_2
        tv_part15.text = partici_2
        tv_part16.text = partici_2

        SetearTextView()

    }

    @SuppressLint("ResourceType")
    private fun SetearTextView() {

        tv_titul1.id = 1
        tv_part1.id = 2
        tv_titul2.id = 3
        tv_part2.id = 4
        tv_titul3.id = 5
        tv_part3.id = 6
        tv_titul4.id = 7
        tv_part4.id = 8
        tv_titul5.id = 9
        tv_part5.id = 10
        tv_titul6.id =11
        tv_part6.id = 12
        tv_titul7.id = 13
        tv_part7.id = 14
        tv_titul8.id = 15
        tv_part8.id = 16
        tv_titul9.id = 17
        tv_part9.id = 18
        tv_titul10.id = 19
        tv_part10.id = 20
        tv_titul11.id = 21
        tv_part11.id = 22
        tv_titul12.id = 23
        tv_part12.id = 24
        tv_titul13.id = 25
        tv_part13.id = 26
        tv_titul14.id = 27
        tv_part14.id = 28
        tv_titul15.id = 29
        tv_part15.id = 30
        tv_titul16.id = 31
        tv_part16.id = 32
        for (i in 1..(num_particif1.toInt())*2){
            findViewById<TextView>(i).visibility = View.VISIBLE
        }

    }

    private fun Guardar_Newreser_Firebase() {


        val auth: FirebaseAuth
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        val database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("reservas")

        val reserva = Reservas(
            hora = hora, fecha = fecha, escenario = escenario, num_doc_part1 = partici_1, num_doc_part2 = partici_2,
            num_doc_part3 = partici_3, num_doc_part4 = partici_4,num_doc_part5 = partici_5, num_doc_part6 = partici_6,
            num_doc_part7 = partici_7, num_doc_part8 = partici_8, num_doc_part9 = partici_9, num_doc_part10 = partici_10,
            num_doc_part11 = partici_11, num_doc_part12 = partici_12, num_doc_part13 = partici_13, num_doc_part14 = partici_14,
            num_doc_part15 = partici_15, num_doc_part16 = partici_16
        )

        myRef.child(fecha).child(escenario).child(user!!.uid).setValue(reserva).addOnSuccessListener {
            flag ++
            Toast.makeText(this, flag.toString(),Toast.LENGTH_SHORT).show()
        }

        myRef = database.getReference("reservasuser")
        val idreserva = myRef.push().key

        val reserval = ReservasLocal(
            cancha = escenario, estado = "Pendiente", fecha = fecha, hora = hora, num_doc_part1 = partici_1, num_doc_part2 = partici_2,
            num_doc_part3 = partici_3, num_doc_part4 = partici_4,num_doc_part5 = partici_5, num_doc_part6 = partici_6,
            num_doc_part7 = partici_7, num_doc_part8 = partici_8, num_doc_part9 = partici_9, num_doc_part10 = partici_10,
            num_doc_part11 = partici_11, num_doc_part12 = partici_12, num_doc_part13 = partici_13, num_doc_part14 = partici_14,
            num_doc_part15 = partici_15, num_doc_part16 = partici_16
        )

        myRef.child(user.uid).child(idreserva!!).setValue(reserval).addOnSuccessListener {
            flag ++
            Toast.makeText(this, flag.toString(),Toast.LENGTH_SHORT).show()
            if (flag==2){
                flag = 0
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }



}
