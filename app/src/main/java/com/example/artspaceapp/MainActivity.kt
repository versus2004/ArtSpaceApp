package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAPpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAPpTheme {
                Logic()
            }
        }
    }
}



@Composable
fun image(resource:Int){
    Box(modifier = Modifier
        .shadow(25.dp)
        .background(color = Color.White)
        .padding(30.dp)) {

        Image(painter = painterResource(id = resource), contentDescription = null)


    }


}


@Composable
fun Logic(){


    var count by remember {
        mutableStateOf(0)
    }

    when(count){
        0-> Ui(resource = R.drawable.daniel_koponyas_uz_xsuxj2hg_unsplash, ArtWorkTitle = "Sunset Image", ArtWorkArtist = "Daniel", onPreviousButton = {
            if(count==0){count=3}
            else{count--}
             }, onNextButton = {count++})
        1-> Ui(resource = R.drawable.payman_shojaei_kxw7q5von3o_unsplash, ArtWorkTitle = "Flowers", ArtWorkArtist = "Payman", onPreviousButton = { count-- }, onNextButton = {count++})
         2-> Ui(
             resource = R.drawable.andrew_sterling_jzery_mafwq_unsplash,
             ArtWorkTitle = "Waterfall",
             ArtWorkArtist = "Andrew",
             onPreviousButton = { count-- } , onNextButton ={count++})
        3-> Ui(resource = R.drawable.tobias_reich_vltye88rkt8_unsplash, ArtWorkTitle = "Mountain", ArtWorkArtist ="Tobias" , onPreviousButton = {count--} , onNextButton = {count=0})


        }
        }





@Composable
fun Ui(resource: Int ,ArtWorkTitle : String , ArtWorkArtist: String , onPreviousButton: () -> Unit , onNextButton: () -> Unit){

    Column(Modifier.padding(35.dp) , verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(50.dp))
        image(resource = resource)
        TextInformation(ArtWorkTitle = ArtWorkTitle, ArtWorkArtist = ArtWorkArtist)

        Buttons(onPreviousButton , onNextButton)
    }
}
@Composable
fun TextInformation(ArtWorkTitle:String , ArtWorkArtist:String){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(25.dp) , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {

    Text(text = ArtWorkTitle  )
    Text(text = ArtWorkArtist )}
}
@Composable
fun Buttons(onNextButton:()->Unit , onPreviousButton:()->Unit){
    Row(
        Modifier
            .padding(40.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween ) {
        Button(onClick = onPreviousButton  , shape = RectangleShape) {
            Text(text = "Previous")
        }
         Spacer(modifier = Modifier.weight(1f))
        Button(onClick = onNextButton  ,shape = RectangleShape) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true
)
@Composable
fun PreviewCOmposable(){

//Ui(R.drawable.daniel_koponyas_uz_xsuxj2hg_unsplash ,  " Real" , "Unreal", {5+5})

}