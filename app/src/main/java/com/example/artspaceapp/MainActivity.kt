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
fun Ui(){
    Column(Modifier.padding(35.dp)) {
        image(resource = R.drawable.daniel_koponyas_uz_xsuxj2hg_unsplash)
        TextInformation(ArtWorkTitle = "ArtWorkTitle", ArtWorkArtist = "ArtWorkArtist")
        Buttons()
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
fun Buttons(){
    Row(
        Modifier
            .padding(40.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween ) {
        Button(onClick = { /*TODO*/ } , Modifier.weight(1f) , shape = RectangleShape) {
            Text(text = "Previous")
        }
         Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { /*TODO*/ } , Modifier.weight(1f) ,shape = RectangleShape) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true
)
@Composable
fun PreviewCOmposable(){

Ui()

}