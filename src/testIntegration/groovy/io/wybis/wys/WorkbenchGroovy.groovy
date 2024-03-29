import io.wybis.wys.model.Branch

import com.fasterxml.jackson.databind.ObjectMapper

ObjectMapper jom = new ObjectMapper()

String json = '''
{
  "name": "Max Money",
  "products": [
    {
      "code": "USD",
      "name": "United States Dollar",
      "baseUnit": 1,
      "denominator": 1,
      "buyRate": 3.24,
      "buyPercent": 10,
      "sellRate": 3.295,
      "sellPercent": 10
    },
    {
      "code": "GBP",
      "name": "United Kingdom Pound",
      "baseUnit": 1,
      "denominator": 1,
      "buyRate": 5.34,
      "buyPercent": 10,
      "sellRate": 5.4,
      "sellPercent": 10
    },
    {
      "code": "EUR",
      "name": "European Euro",
      "baseUnit": 1,
      "denominator": 1,
      "buyRate": 4.43,
      "buyPercent": 10,
      "sellRate": 4.48,
      "sellPercent": 10
    }
  ],
  "employees": [
    {
      "userId": "munmin2000@maxmoney",
      "password": "1234",
      "firstName": "Munavar Ali",
      "roleId": "Manager"
    },
    {
      "userId": "feroz@maxmoney",
      "password": "1234",
      "firstName": "Feroz",
      "roleId": "Employee"
    },
    {
      "userId": "rahamathulla@ramnadu_medicals",
      "password": "1234",
      "firstName": "Rahamathulla",
      "roleId": "Employee"
    }
  ],
  "dealers": [
    {
      "firstName": "Rapid Million"
    },
    {
      "firstName": "Ok Money"
    }
  ],
  "customers": [
    {
      "firstName": "Arun Nair"
    },
    {
      "firstName": "Shahul Hameed"
    }
  ]
}
'''
Branch branch = jom.readValue(json, Branch.class);
println branch

StringWriter sw = new StringWriter()
jom.writeValue(sw, branch)
println sw

