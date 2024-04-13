package com.example.unitconverterproject1buttonboxdropdownmanymore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterproject1buttonboxdropdownmanymore.ui.theme.UnitConverterProject1buttonBoxDropdownManymoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterProject1buttonBoxDropdownManymoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    unitConverter()
                }
            }
        }
    }
}

@Composable
fun unitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oconversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 40.sp,
        color = Color.Red
    )




    fun converterUnits(){
        // ?:   ->  is elvis operator it is like  a smart very short  if statement
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result  = ((inputValueDouble*conversionFactor.value*100)/oconversionFactor.value) / 100.0
        outputValue = result.toString()


    }








    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        // here all the UI elements will get stacked below each other
        Text(text = "Unit Converter" , style = customTextStyle)
        // we can write our content here

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                converterUnits()
            // here what should happens , when the value of our outlinedTextField changes (the box where the user will give input)
            },
            label = { Text(text = "Enter Value")})

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // input box
            val context = LocalContext.current
            /*
            Button(onClick = { Toast.makeText(context,
                "Thanks for clicking" ,
                Toast.LENGTH_LONG).show() }) {
                Text(text = "Click Me!")
            }
            */
            Box {
                // input button
                Button(onClick = {iExpanded= true }) {
                    Text(text = inputUnit)
                    androidx.compose.material3.Icon(Icons.Default.ArrowDropDown , contentDescription = "Arrow down")

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeter"
                        conversionFactor.value = 0.01
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meter")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Meter"
                        conversionFactor.value = 1.0
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        conversionFactor.value = 0.3048
                        converterUnits()
                    })

                    DropdownMenuItem(text = { Text(text = "Kilometer")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Kilometer"
                        conversionFactor.value = 1000.0
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Decimeter")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Decimeter"
                        conversionFactor.value = 0.1
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Micrometer")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Micrometer"
                        conversionFactor.value = 0.000001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Nanometer")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Nanometer"
                        conversionFactor.value = 0.001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Picometer")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Picometer"
                        conversionFactor.value = 0.000000000001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Inch")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Inch"
                        conversionFactor.value = 0.0254
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Miles")  }, onClick = {
                        iExpanded = false
                        inputUnit = "Miles"
                        conversionFactor.value = 1609.34
                        converterUnits()
                    })


                }
            }
            Spacer(modifier = Modifier.width(30.dp))
            // output button


            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    androidx.compose.material3.Icon(Icons.Default.ArrowDropDown, contentDescription ="good to see you" )

                }
                DropdownMenu(expanded = oExpanded , onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeter"
                        oconversionFactor.value = 0.01
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meter")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Meter"
                        oconversionFactor.value = 1.00
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        oconversionFactor.value = 0.3048
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Milimeter")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Milimeter"
                        oconversionFactor.value = 0.001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Kilometer")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Kilometer"
                        oconversionFactor.value = 1000.0
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Decimeter")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Decimeter"
                        oconversionFactor.value = 0.1
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Micrometer")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Micrometer"
                        oconversionFactor.value = 0.000001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Nanometer")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Nanometer"
                        oconversionFactor.value = 0.001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Picometer")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Picometer"
                        oconversionFactor.value = 0.000000000001
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Inch")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Inch"
                        oconversionFactor.value = 0.0254
                        converterUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Miles")  }, onClick = {
                        oExpanded = false
                        outputUnit = "Miles"
                        oconversionFactor.value = 1609.34
                        converterUnits()
                    })


                }
            }







        }

        // here all the UI elements will get stacked next to  each other
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result : $outputValue $outputUnit" , style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(450.dp))
        Text(text = "ALL RIGHT RESERVED")
        Text(text = "MADE BY : Ankush")


    }

}






@Preview(showBackground = true)
@Composable
fun unitconverterPreview(){
    unitConverter()

}