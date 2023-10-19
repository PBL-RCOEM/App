package com.example.smart_appointment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.example.smart_appointment.R
import java.util.LinkedHashMap

class MainActivity : AppCompatActivity() {

    private val items = linkedSetOf(
        "itching", "skin_rash", "nodal_skin_eruptions", "continuous_sneezing", "shivering", "chills",
        "joint_pain", "stomach_pain", "acidity", "ulcers_on_tongue", "muscle_wasting", "vomiting",
        "burning_micturition", "spotting_ urination", "fatigue", "weight_gain", "anxiety",
        "cold_hands_and_feets", "mood_swings", "weight_loss", "restlessness", "lethargy",
        "patches_in_throat", "irregular_sugar_level", "cough", "high_fever", "sunken_eyes",
        "breathlessness", "sweating", "dehydration", "indigestion", "headache", "yellowish_skin",
        "dark_urine", "nausea", "loss_of_appetite", "pain_behind_the_eyes", "back_pain", "constipation",
        "abdominal_pain", "diarrhea", "mild_fever", "yellow_urine", "yellowing_of_eyes",
        "acute_liver_failure", "fluid_overload", "swelling_of_stomach", "swelled_lymph_nodes",
        "malaise", "blurred_and_distorted_vision", "phlegm", "throat_irritation", "redness_of_eyes",
        "sinus_pressure", "runny_nose", "congestion", "chest_pain", "weakness_in_limbs",
        "fast_heart_rate", "pain_during_bowel_movements", "pain_in_anal_region", "bloody_stool",
        "irritation_in_anus", "neck_pain", "dizziness", "cramps", "bruising", "obesity",
        "swollen_legs", "swollen_blood_vessels", "puffy_face_and_eyes", "enlarged_thyroid",
        "brittle_nails", "swollen_extremities", "excessive_hunger", "extra_marital_contacts",
        "drying_and_tingling_lips", "slurred_speech", "knee_pain", "hip_joint_pain", "muscle_weakness",
        "stiff_neck", "swelling_joints", "movement_stiffness", "spinning_movements", "loss_of_balance",
        "unsteadiness", "weakness_of_one_body_side", "loss_of_smell", "bladder_discomfort",
        "foul_smell_of_urine", "continuous_feel_of_urine", "passage_of_gases", "internal_itching",
        "toxic_look_(typhos)", "depression", "irritability", "muscle_pain", "altered_sensorium",
        "red_spots_over_body", "belly_pain", "abnormal_menstruation", "dischromic_patches",
        "watering_from_eyes", "increased_appetite", "polyuria", "family_history", "mucoid_sputum",
        "rusty_sputum", "lack_of_concentration", "visual_disturbances", "receiving_blood_transfusion",
        "receiving_unsterile_injections", "coma", "stomach_bleeding", "distention_of_abdomen",
        "history_of_alcohol_consumption", "fluid_overload", "blood_in_sputum", "prominent_veins_on_calf",
        "palpitations", "painful_walking", "pus_filled_pimples", "blackheads", "scurring",
        "skin_peeling", "silver_like_dusting", "small_dents_in_nails", "inflammatory_nails",
        "blister", "red_sore_around_nose", "yellow_crust_ooze", "prognosis"    )

    private val selectedItems = LinkedHashMap<String, Int>()
    private lateinit var symptomsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        symptomsTextView = findViewById(R.id.symptomsTextView) // Find the TextView

        // Initialize selectedItems with all items having a value of 0
        items.forEach { selectedItems[it] = 0 }

        // Create an ArrayAdapter with your item list and set it to the AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items.toList())
        autoCompleteTextView.setAdapter(adapter)

        // Set an item click listener to handle item selection
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Mark as selected by updating the value to 1
            selectedItems[selectedItem] = 1

            // Update the symptoms TextView to display the selected items
            updateSymptomsText()
        }
    }

    private fun updateSymptomsText() {
        val selectedSymptoms = selectedItems
            .filter { it.value == 1 }
            .keys
            .mapIndexed { index, symptom -> "${index + 1}) $symptom" } // Add numbers

        symptomsTextView.text = "Selected Symptoms:\n${selectedSymptoms.joinToString("\n")}"
    }

}
