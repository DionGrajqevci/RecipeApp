package com.example.therecipeapp.domain.models
import com.google.gson.annotations.SerializedName


data class RecipesResponse (

    @SerializedName("recipes" ) var recipes : ArrayList<Recipes> = arrayListOf()

)

data class Us (

    @SerializedName("amount"    ) var amount    : Double?    = null,
    @SerializedName("unitShort" ) var unitShort : String? = null,
    @SerializedName("unitLong"  ) var unitLong  : String? = null

)

data class Metric (

    @SerializedName("amount"    ) var amount    : Double?    = null,
    @SerializedName("unitShort" ) var unitShort : String? = null,
    @SerializedName("unitLong"  ) var unitLong  : String? = null

)

data class Measures (

    @SerializedName("us"     ) var us     : Us?     = Us(),
    @SerializedName("metric" ) var metric : Metric? = Metric()

)

data class ExtendedIngredients (

    @SerializedName("id"           ) var id           : Int?              = null,
    @SerializedName("aisle"        ) var aisle        : String?           = null,
    @SerializedName("image"        ) var image        : String?           = null,
    @SerializedName("consistency"  ) var consistency  : String?           = null,
    @SerializedName("name"         ) var name         : String?           = null,
    @SerializedName("nameClean"    ) var nameClean    : String?           = null,
    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("originalName" ) var originalName : String?           = null,
    @SerializedName("amount"       ) var amount       : Double?              = null,
    @SerializedName("unit"         ) var unit         : String?           = null,
    @SerializedName("meta"         ) var meta         : ArrayList<String> = arrayListOf(),
    @SerializedName("measures"     ) var measures     : Measures?         = Measures()

)

data class Ingredients (

    @SerializedName("id"            ) var id            : Int?    = null,
    @SerializedName("name"          ) var name          : String? = null,
    @SerializedName("localizedName" ) var localizedName : String? = null,
    @SerializedName("image"         ) var image         : String? = null

)



data class Length (

    @SerializedName("number" ) var number : Int?    = null,
    @SerializedName("unit"   ) var unit   : String? = null

)

data class Steps (

    @SerializedName("number"      ) var number      : Int?                   = null,
    @SerializedName("step"        ) var step        : String?                = null,
    @SerializedName("ingredients" ) var ingredients : ArrayList<Ingredients> = arrayListOf(),
    @SerializedName("equipment") var equipment: Any? = null,
    @SerializedName("length"      ) var length      : Length?                = Length()

)

data class AnalyzedInstructions (

    @SerializedName("name"  ) var name  : String?          = null,
    @SerializedName("steps" ) var steps : ArrayList<Steps> = arrayListOf()

)

data class Recipes (

    @SerializedName("vegetarian"               ) var vegetarian               : Boolean?                        = null,
    @SerializedName("vegan"                    ) var vegan                    : Boolean?                        = null,
    @SerializedName("glutenFree"               ) var glutenFree               : Boolean?                        = null,
    @SerializedName("dairyFree"                ) var dairyFree                : Boolean?                        = null,
    @SerializedName("veryHealthy"              ) var veryHealthy              : Boolean?                        = null,
    @SerializedName("cheap"                    ) var cheap                    : Boolean?                        = null,
    @SerializedName("veryPopular"              ) var veryPopular              : Boolean?                        = null,
    @SerializedName("sustainable"              ) var sustainable              : Boolean?                        = null,
    @SerializedName("lowFodmap"                ) var lowFodmap                : Boolean?                        = null,
    @SerializedName("weightWatcherSmartPoints" ) var weightWatcherSmartPoints : Int?                            = null,
    @SerializedName("gaps"                     ) var gaps                     : String?                         = null,
    @SerializedName("preparationMinutes"       ) var preparationMinutes       : Int?                            = null,
    @SerializedName("cookingMinutes"           ) var cookingMinutes           : Int?                            = null,
    @SerializedName("aggregateLikes"           ) var aggregateLikes           : Int?                            = null,
    @SerializedName("healthScore"              ) var healthScore              : Int?                            = null,
    @SerializedName("creditsText"              ) var creditsText              : String?                         = null,
    @SerializedName("license"                  ) var license                  : String?                         = null,
    @SerializedName("sourceName"               ) var sourceName               : String?                         = null,
    @SerializedName("pricePerServing"          ) var pricePerServing          : Double?                         = null,
    @SerializedName("extendedIngredients"      ) var extendedIngredients      : ArrayList<ExtendedIngredients>  = arrayListOf(),
    @SerializedName("id"                       ) var id                       : Int?                            = null,
    @SerializedName("title"                    ) var title                    : String?                         = null,
    @SerializedName("readyInMinutes"           ) var readyInMinutes           : Int?                            = null,
    @SerializedName("servings"                 ) var servings                 : Int?                            = null,
    @SerializedName("sourceUrl"                ) var sourceUrl                : String?                         = null,
    @SerializedName("image"                    ) var image                    : String?                         = null,
    @SerializedName("imageType"                ) var imageType                : String?                         = null,
    @SerializedName("summary"                  ) var summary                  : String?                         = null,
    @SerializedName("cuisines"                 ) var cuisines                 : ArrayList<String>               = arrayListOf(),
    @SerializedName("dishTypes"                ) var dishTypes                : ArrayList<String>               = arrayListOf(),
    @SerializedName("diets"                    ) var diets                    : ArrayList<String>               = arrayListOf(),
    @SerializedName("occasions"                ) var occasions                : ArrayList<String>               = arrayListOf(),
    @SerializedName("instructions"             ) var instructions             : String?                         = null,
    @SerializedName("analyzedInstructions"     ) var analyzedInstructions     : ArrayList<AnalyzedInstructions> = arrayListOf(),
    @SerializedName("originalId"               ) var originalId               : String?                         = null,
    @SerializedName("spoonacularSourceUrl"     ) var spoonacularSourceUrl     : String?                         = null

)