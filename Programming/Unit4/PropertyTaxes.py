# This program will calcualte the assessment value and the property tax of a
# property. The assessment value of a property is 60% of the property’s actual
# value, while the property tax rate is 0.72%
# Sarah Gu

# Calculate assessment value and property tax value
def property_taxes(value):
    assessmentValue = 0.6 * value
    propertyTax = 0.0072 * assessmentValue
    return assessmentValue, propertyTax

for eachTime in range(1, 4):
    propertyValue = float(input('How much is the property value? '))
    assessment, tax = property_taxes(propertyValue)
    print(format(assessment, '.2f') + ',', format(tax, '.2f'))
