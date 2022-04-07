package com.example.koufee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.koufee.ui.theme.*

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
                    ItemCoffe()
                }
            }
        }
    }
}

@Composable
fun ItemCoffe() {
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


    }


}

@Composable
fun TextArea() {
    val imStar = painterResource(id = R.drawable.ic_star)
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.heart))
    // Chip state
    val textChipRememberOneState = remember {
        mutableStateOf(false)
    }
    val milkChoice = listOf(
        stringResource(R.string.oat_milk), stringResource(R.string.soy_milk),
        stringResource(R.string.almond_milk)
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(R.string.coffee_name),
            fontFamily = rosarivoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp
        )
        LottieAnimation(composition, Modifier.size(50.dp))

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = stringResource(R.string.coffee_headline),
            fontFamily = rosarivoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Image(painter = imStar, contentDescription = "im_star")
        Text(
            text = "4.5", fontFamily = rosarivoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )

    }
    Text(
        text = stringResource(R.string.coffee_description),
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    Text(
        text = stringResource(R.string.milk_choice),
        fontFamily = rosarivoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
    /*    items(milkChoice) {
            TextChip(
                isSelected = textChipRememberOneState.value,
                text = it,
                selectedColor = Grege,
                onChecked = { state ->
                    textChipRememberOneState.value = state
                }
            )
        }*/

        items(1){
            TextChip(
                isSelected = textChipRememberOneState.value,
                text = milkChoice[0],
                selectedColor = Grege,
                onChecked = { state ->
                    textChipRememberOneState.value = state
                }
            )
            TextChip(
                isSelected = textChipRememberOneState.value,
                text = milkChoice[1],
                selectedColor = Grege,
                onChecked = { state ->
                    textChipRememberOneState.value = state
                }
            )
        }
    }


}


@Composable
fun TextChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = Grege
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else Grege,
                RoundedCornerShape(10.dp)
            )
            .background(
                color = if (isSelected) selectedColor else Brownie,
                RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {
                onChecked(!isSelected)
            }
            .padding(10.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Brownie else Grege,
            fontFamily = rosarivoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp

        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoufeeTheme {
        ItemCoffe()
    }
}