package com.example.permisoandroid

import android.content.pm.PackageManager
import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.permisoandroid.databinding.ActivityMainBinding

// import kotlinx.android.synthetic.main.activity_main
// import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
//    private val CAMERA_REQUEST_CODE = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
        binding.btnFoto.setOnClickListener {
            checkCameraPermission()
        }
//        btnFoto.setOnClickListener {
//            checkCameraPermission()
//        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
//  LesYoRejeteDemandOuA, PermisoNoAceptadoPorElMomento
            requestCameraPermission()
        } else  {
            //LouvriCamera
            openCamera()
        }
        }

//            return openCamera()



    private fun openCamera() {
        Toast.makeText(this, "Abriendo Camara", Toast.LENGTH_SHORT).show()
    }

    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
Toast.makeText(this, "El usuario ya ha rechazado los permisos", Toast.LENGTH_SHORT).show()

//  LesUsuarioARejetePermissionYo
        } else {
//  PedirPermissions
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CAMERA),
            121198)
    }
}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 121198 ) { // PermisyonAnDweAksepteAkKodSa
            if (grantResults.isNotEmpty() && grantResults[0]
                == PackageManager.PERMISSION_GRANTED) {
                    openCamera()
            } else {
                Toast.makeText(this, "Permisos rechazados por primera vez", Toast.LENGTH_SHORT).show()
            }
        }

    }

}



