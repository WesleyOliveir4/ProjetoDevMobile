package com.example.orgs.extensoes

import android.widget.ImageView
import coil.load
import com.example.orgs.R


    fun ImageView.CarregaImagem(url: String? = null){
        load(url){
            fallback(R.drawable.error)
            error(R.drawable.error)
            placeholder(R.drawable.plano_de_fundo)
        }
    }
