package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.repository.PokemonRepository

class DetailFragment : Fragment() {
    private var _binding : FragmentDetailBinding? = null;
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val pokemonId = args.pokemonId

        val pokemonList = PokemonRepository().getPokemonList()
        val currentPokemon = pokemonList.get(pokemonId-1)
        _binding!!.pokemonNameTextView.text = currentPokemon.name

        Picasso.get().load(currentPokemon.imageUrlFront).into(_binding!!.imageView2)
        Picasso.get().load(currentPokemon.imageUrlBack).into(_binding!!.imageView3)
        Picasso.get().load(currentPokemon.imageUrlShinnyFront).into(_binding!!.imageView4)
        Picasso.get().load(currentPokemon.imageUrlShinnyBack).into(_binding!!.imageView5)

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}