import mysql.connector
import pandas as pd

connection = mysql.connector.connect(
    host = "localhost",
    user = "root",
    password = "",
    database = "practica"
)

# Extraemos los datos de la tabla de Empleados
employeesInfo = "SELECT * FROM em_empleados"

# Llevamos la información de Empleados al Dataframe
df = pd.read_sql(employeesInfo, connection)

# Lo pasamos a un archivo csv
df.to_csv("employees.csv", index=False)



#Extraemos los datos de la tabla Proyectos y seguimos el mismo proceso para el dataframe
projectsInfo = "SELECT * FROM pr_proyectos"

df = pd.read_sql(projectsInfo, connection)
df.to_csv('projects.csv', index=False)



#Extraemos los datos de la tabla Empleados_Proyectos
employeesProjectsInfo = "SELECT * FROM empleado_proyecto"
df = pd.read_sql(employeesProjectsInfo, connection)
df.to_csv("employees_projects.csv", index = False)

connection.close()