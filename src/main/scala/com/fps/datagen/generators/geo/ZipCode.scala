package com.fps.datagen.generators.geo

/* @author medge */

/**
 * Model representing a JSON entry in zipcodes.json
 *
 * {"zip":"10001","latitude":40.71,"longitude":-73.99,"city":"New York","state":"NY"}
 */
case class ZipCode(
  zip: String,
  latitude: Double,
  longitude: Double,
  city: String,
  state: String
)