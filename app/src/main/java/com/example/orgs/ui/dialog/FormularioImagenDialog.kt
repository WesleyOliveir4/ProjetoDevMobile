package com.example.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.orgs.databinding.FormularioImagemBinding
import com.example.orgs.extensoes.CarregaImagem

class FormularioImagenDialog(private val contexto: Context) {

    fun Mostra(){
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(contexto))
            binding.btnCarregarImagemFormulario.setOnClickListener(){
                val urlTexto = binding.inputTextUrlImg.text.toString()
                binding.imagemFormularioAdd.CarregaImagem(urlTexto)
            }
        AlertDialog.Builder(contexto)
            .setView(binding.root)
            .setTitle("Titulo teste")
            .setMessage("Titulo mensagem")
            .setPositiveButton("Confirmar"){_, _ ->
//              val url = binding.inputTextUrlImg.text.toString()
//                binding.imagemFormulario.CarregaImagem(url)
            }
            .setNegativeButton("Cancelar"){_, _ ->

            }
            .show()
    }
}