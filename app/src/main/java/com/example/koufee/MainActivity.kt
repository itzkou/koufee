package com.example.koufee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.koufee.ui.theme.KoufeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoufeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ItemCoffe("Android")
                }
            }
        }
    }
}

@Composable
fun ItemCoffe(name: String) {
    val image: Painter = painterResource(R.drawable.ic_coffee)

    Column(
        modifier = Modifier.padding(16.dp),

        ) {
        Image(
            painter = image, contentDescription = "ic_coffee",
            modifier = Modifier
                .height(344.dp)
                .fillMaxWidth()
        )
        Text(text = "Cappuccino")
        Text(text = "Drizzled with Caramel")
        Text(text = "A single espresso shot poured into hot foamy milk, with the surface topped with mildly sweetened cocoa powder and drizzled with scrumptious caramel syrup ...")


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoufeeTheme {
        ItemCoffe("Android")
    }
}