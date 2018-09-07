package br.com.rafaeldias.demofragment

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btPrimeiro.setOnClickListener {
            //trocaFragment(PrimeiroFragment())
            val primeiroFragment = PrimeiroFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragmento 1")
            primeiroFragment.arguments = bundle
            trocaFragment(primeiroFragment, "frag1")
        }

        btSegundo.setOnClickListener {
            //trocaFragment(SegundoFragment())
            val segundoFragment = SegundoFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragmento 2")
            segundoFragment.arguments = bundle
            trocaFragment(segundoFragment, "frag2")
        }
    }

    private fun trocaFragment(fragment: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerFragment, fragment)
        ft.addToBackStack(tag) //ao clica no "voltar" do android, vai voltando os fragmentos da pilha
        ft.commit()
    }
}
