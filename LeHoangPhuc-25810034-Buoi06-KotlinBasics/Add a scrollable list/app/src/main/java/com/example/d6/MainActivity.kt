package com.example.d6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.d6.data.Datasource
import com.example.d6.model.Affirmation
import com.example.d6.ui.theme.D6Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            D6Theme {
                AffirmationsApp()
            }
        }
    }

    @Composable
    fun AffirmationsApp() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()

        ) {
            AffirmationList(
                affirmationList = Datasource().loadAffirmation()
            )
        }
    }

    @Composable
    fun AffirmationCard(
        affirmation: Affirmation,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier
        ) {
            Column {
                Image(
                    painter = painterResource(
                        affirmation.imageResourceId
                    ),
                    contentDescription = stringResource(
                        affirmation.stringResourceId
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = stringResource(
                        affirmation.stringResourceId
                    ),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }

    @Composable
    fun AffirmationList(
        affirmationList: List<Affirmation>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            items(affirmationList) { affirmation ->
                AffirmationCard(
                    affirmation = affirmation,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

//
//    @Preview(showBackground = true)
//    @Composable
//    private fun AffirmationCardPreview() {
//        D6Theme {
//            AffirmationCard(
//                Affirmation(
//                    R.string.affirmation1,
//                    R.drawable.meo_1
//                )
//            )
//        }
//    }
}