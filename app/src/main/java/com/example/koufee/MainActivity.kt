package com.example.koufee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.koufee.ui.theme.Brownie
import com.example.koufee.ui.theme.Grege
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
    val imCoffe: Painter = painterResource(R.drawable.ic_coffee)


    Column(
        modifier = Modifier.padding(16.dp)

    ) {
        Image(
            painter = imCoffe, contentDescription = "ic_coffee",
            modifier = Modifier
                .height(412.dp)
                .width(344.dp)
                .align(Alignment.CenterHorizontally)
        )
        TextArea()

        ButtonColor()


    }


}

@Composable
fun TextArea() {
    val imStar = painterResource(id = R.drawable.ic_star)
    Text(text = "Cappuccino")
    Row(verticalAlignment = Alignment.CenterVertically) {

        Text(text = "Drizzled with Caramel")
        Image(painter = imStar, contentDescription = "im_star")
        Text(text = "4.5")

    }
    Text(text = "A single espresso shot poured into hot foamy milk, with the surface topped with mildly sweetened cocoa powder and drizzled with scrumptious caramel syrup ...")

    Text(text = "Choice of Milk")
}

@Composable
fun ButtonColor() {

    val selected = remember { mutableStateOf(false) }

    Button(colors = ButtonDefaults.buttonColors(
        backgroundColor = if (selected.value) Grege else Brownie
    ),
        onClick = { selected.value = !selected.value }) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoufeeTheme {
        ItemCoffe("Android")
    }
}