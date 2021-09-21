package decorballoon;

import Connection.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class DecorBalloonController {

    @FXML
    private Button buttonRegistrar;

    @FXML
    private TextField txf_ID;

    @FXML
    private TextField txf_telefono;

    @FXML
    private TextField txf_tipo;

    @FXML
    private TextField txf_direccion;

    @FXML
    private TextField txf_valor;

    @FXML
    private TextField txf_nombre;

    @FXML
    private Label lb_registrado;

    @FXML
    private TextArea Pendientes;

    @FXML
    private Button buttonConsultar;

    @FXML
    private TextArea txf_entregados;

    @FXML
    private Button buttonConsultar1;

    @FXML
    private Button buttonEntrega;

    @FXML
    private Button buttonBuscarEntrega;

    @FXML
    private TextField txf_ID1;

    @FXML
    private TextField txf_telefono1;

    @FXML
    private TextField txf_tipo1;

    @FXML
    private TextField txf_envio1;

    @FXML
    private TextField txf_valor1;

    @FXML
    private TextField txf_estado1;

    @FXML
    private TextField txf_nombre1;

    @FXML
    private TextField txf_ConsultaID;

    @FXML
    private TextField txf_ID2;

    @FXML
    private TextField txf_telefono2;

    @FXML
    private TextField txf_tipo2;

    @FXML
    private TextField txf_direccion2;

    @FXML
    private TextField txf_valor2;

    @FXML
    private TextField txf_estado2;

    @FXML
    private TextField txf_nombre2;

    @FXML
    private TextField txf_consulta;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonModificar;

    @FXML
    private Label lb_notificacion;
    
    @FXML
    private Label lb_notificacionpendientes;

 
    @FXML
    void Buscar(ActionEvent event) {
        
        int IDConsultado = Integer.parseInt(txf_consulta.getText());//Buscando la ID digita en el boton
        Connect ObjConexion = new Connect();
        String BuscarID= "SELECT * FROM pedidos WHERE ID ="+IDConsultado;
        System.out.println(BuscarID);
        


        try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
        ResultSet resultSet = stmt.executeQuery(BuscarID); //Ejecutar la consulta
                txf_nombre2.setText(resultSet.getString(1)); 
                txf_ID2.setText(resultSet.getString(2));
                txf_telefono2.setText(resultSet.getString(3));
                txf_tipo2.setText(resultSet.getString(4));
                txf_direccion2.setText(resultSet.getString(5));
                txf_valor2.setText(resultSet.getString(6));
                txf_estado2.setText(resultSet.getString(7));
            

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        lb_notificacion.setText("");
    }   
    @FXML
    void ConsultarEntrega(ActionEvent event) {
         txf_ID1.setText(txf_ConsultaID.getText().trim());
        //Alerta cuando se digite un ID errado; 
        //Si el ID esta vacio, con espacio se genera el error

            int IDConsultado = Integer.parseInt(txf_ConsultaID.getText());//Buscando la ID digita en el boton
            Connect ObjConexion = new Connect();
            String BuscarID= "SELECT * FROM pedidos WHERE ID ="+IDConsultado;
            System.out.println(BuscarID);
        

            try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery(BuscarID); //Ejecutar la consulta
                txf_nombre1.setText(resultSet.getString(1)); 
                txf_ID1.setText(resultSet.getString(2));
                txf_telefono1.setText(resultSet.getString(3));
                txf_tipo1.setText(resultSet.getString(4));
                txf_envio1.setText(resultSet.getString(5));
                txf_valor1.setText(resultSet.getString(6));
                txf_estado1.setText(resultSet.getString(7));
            
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }

    }

    @FXML
    void Entregar(ActionEvent event) {
         txf_ID1.setText(txf_ConsultaID.getText().trim());
        //Alerta cuando se digite un ID errado; 
        //Si el ID esta vacio, con espacio se genera el error
        String estado="Entregado";
        int IDConsultado = Integer.parseInt(txf_ConsultaID.getText());//Buscando la ID digita en el boton
        Connect ObjConexion = new Connect();
        String BuscarID= "SELECT * FROM pedidos WHERE ID ="+IDConsultado;
        System.out.println(BuscarID);
        


        try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
        ResultSet resultSet = stmt.executeQuery(BuscarID); //Ejecutar la consulta
                txf_nombre1.setText(resultSet.getString(1)); 
                txf_ID1.setText(resultSet.getString(2));
                txf_telefono1.setText(resultSet.getString(3));
                txf_tipo1.setText(resultSet.getString(4));
                txf_envio1.setText(resultSet.getString(5));
                txf_valor1.setText(resultSet.getString(6));
                txf_estado1.setText(resultSet.getString(7));
            

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(
            "UPDATE pedidos"+" "
            +"SET Estado  =" +"'"+estado+"'"+"WHERE ID = "+IDConsultado);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        String d="";
        if (txf_nombre1.getText() != d){
            txf_nombre1.setText(d);
        }
        if (txf_ID1.getText() != d){
            txf_ID1.setText(d);
        }if (txf_telefono1.getText() != d){
            txf_telefono1.setText(d);
        }if (txf_tipo1.getText() != d){
            txf_tipo1.setText(d);
        }if (txf_envio1.getText() != d){
            txf_envio1.setText(d);
        }if (txf_valor1.getText() != d){
            txf_valor1.setText(d);
        }if (txf_estado1.getText() != d){
            txf_estado1.setText(d);
        }
    

    }

    @FXML
    void Registro(ActionEvent event) {
       
        String d="";
        if (txf_nombre.getText().equals(d)) {
        lb_registrado.setText("ingrese un nombre valido");}
        else if(txf_ID.getText().isEmpty()){
        lb_registrado.setText("ingrese un numero de ID valido");}
        else if (txf_telefono.getText().isEmpty()){
        lb_registrado.setText("ingrese un numero de telefono valido");}
        else if (txf_tipo.getText().isEmpty()){
        lb_registrado.setText("ingrese un tipo de pedido valido");}
        else if (txf_direccion.getText().isEmpty()){
        lb_registrado.setText("ingrese una direccion valida");}
        else if (txf_valor.getText().isEmpty()){
        lb_registrado.setText("ingrese un valor valido");}
        else{
            Connect ObjetoConexion = new Connect();
            String nombre=txf_nombre.getText();
            String ID=(txf_ID.getText());
            String telefono=txf_telefono.getText();
            String tipo=(txf_tipo.getText());
            String direccion=txf_direccion.getText();
            String valor=(txf_valor.getText());
            String estado="Pendiente";

            try(Connection conn = ObjetoConexion.connect(); Statement stmt = conn.createStatement()){
                stmt.executeUpdate(
                    "INSERT INTO pedidos (Nombre,ID,Telefono,Tipo,Direccion,Valor,Estado)"
                    + "VALUES("
                    + "'" + nombre + "'"+","+"'" + ID + "'"+","+"'" + telefono + "'"+ "," +"'" +  tipo +"'"+","+"'"+ direccion+"'"+"," + "'" + valor+ "'"+","+"'"+ estado+"'"+");");

                    System.out.println("tabla actualizada");
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
            lb_registrado.setText("El pedido se registro con exito");

            if (txf_nombre.getText() != d){
                txf_nombre.setText(d);
            }
            if (txf_ID.getText() != d){
                txf_ID.setText(d);
            }if (txf_telefono.getText() != d){
                txf_telefono.setText(d);
            }if (txf_tipo.getText() != d){
                txf_tipo.setText(d);
            }if (txf_direccion.getText() != d){
                txf_direccion.setText(d);
            }if (txf_valor.getText() != d){
                txf_valor.setText(d);
            }
        }
    
    }   

   @FXML
    void pendientes(ActionEvent event) {
         Connect ObjConexion = new Connect();
        String query = "SELECT * FROM pedidos";
        Pendientes.setEditable(false);
        try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            String pedido = "";
            String columnas="";
            while(resultSet.next()){  
                for(int i = 0; i <=numeroColumnas; i++){
                   if( i >= 1){
                        if (resultSet.getString(7).equals("Pendiente")){
                        String valorColumna =resultSet.getString(i); // Obtiene valor de la columna 
                        //pedido = pedido + valorColumna + ", ";
                        String columna = rsmd.getColumnName(i)+ ":"+ "  "+ valorColumna+"\n";
                        columnas=columnas+columna;
                        }
                
                   } 
                   
                }
            columnas =columnas+"----------------------------------------------------------------"+"\n"; 
            }
            
                
        Pendientes.setText(columnas);    
        } catch (SQLException e ){
            System.out.println(e.getMessage());
        } 
       
    }
        @FXML
    void Eliminar(ActionEvent event) {
         Connect ObjetoConexion = new Connect();

        
        String nombre=txf_nombre2.getText();
        String ID=(txf_ID2.getText());
        String telefono=txf_telefono2.getText();
        String tipo=(txf_tipo2.getText());
        String direccion=txf_direccion2.getText();
        String valor=(txf_valor2.getText());
        String estado=txf_estado2.getText();

        try(Connection conn = ObjetoConexion.connect(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(
            "DELETE FROM pedidos"+" "
            +"WHERE Nombre =" +"'"+nombre+"'"+" "+"AND"+" "
                +"ID = "+ID+" "+"AND"+" "
                +"Telefono =" +"'"+telefono+"'"+" "+"AND"+" "
                +"Tipo = " +"'"+tipo+"'"+" "+"AND"+" "
                +"Direccion =" +"'"+direccion+"'"+" "+"AND"+" "
                +"Valor = "+"'"+valor+"'"+" "+"AND"+" "
                +"Estado = "+"'"+estado+"'"+" ");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        String d="";
        if (txf_nombre2.getText() != d){
            txf_nombre2.setText(d);
        }
        if (txf_ID2.getText() != d){
            txf_ID2.setText(d);
        }if (txf_telefono2.getText() != d){
            txf_telefono2.setText(d);
        }if (txf_tipo2.getText() != d){
            txf_tipo2.setText(d);
        }if (txf_direccion2.getText() != d){
            txf_direccion2.setText(d);
        }if (txf_valor2.getText() != d){
            txf_valor2.setText(d);
        }if (txf_estado2.getText() != d){
            txf_estado2.setText(d);
        }
        lb_notificacion.setText("Se ha eliminado con exito ");
    
    }   

    
        @FXML
    void Modificar(ActionEvent event) {
        Connect ObjetoConexion = new Connect();
        String busqueda =(txf_consulta.getText());
         
        String BuscarID= "SELECT * FROM datos WHERE ID ="+busqueda;
        System.out.println(busqueda);
        String nombre=txf_nombre2.getText();
        String ID=(txf_ID2.getText());
        String telefono=txf_telefono2.getText();
        String tipo=(txf_tipo2.getText());
        String direccion=txf_direccion2.getText();
        String valor=(txf_valor2.getText());
        String estado=txf_estado2.getText();

        try(Connection conn = ObjetoConexion.connect(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(
            "UPDATE pedidos"+" "
            +"SET Nombre ="+"'"+nombre+"'"+","+"ID = "+"'"+ID+"'"+","+"Telefono ="+"'"+telefono+"'"+","+"Tipo = "+"'"+tipo+"'"+","+"Direccion ="+"'"+direccion+"'"+","+"Valor = "+"'"+valor+"'"+","+"Estado = "+"'"+estado+"'"+" "
            +"WHERE ID = "+ID);
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        String d="";
        if (txf_nombre2.getText() != d){
            txf_nombre2.setText(d);
        }
        if (txf_ID2.getText() != d){
            txf_ID2.setText(d);
        }if (txf_telefono2.getText() != d){
            txf_telefono2.setText(d);
        }if (txf_tipo2.getText() != d){
            txf_tipo2.setText(d);
        }if (txf_direccion2.getText() != d){
            txf_direccion2.setText(d);
        }if (txf_valor2.getText() != d){
            txf_valor2.setText(d);
        }if (txf_estado2.getText() != d){
            txf_estado2.setText(d);
        }
        lb_notificacion.setText("Ha sido modificado con exito");

    }
        @FXML
    void entregados(ActionEvent event) {  
        Connect ObjConexion = new Connect();
        String query = "SELECT * FROM pedidos";
        txf_entregados.setEditable(false);
        try(Connection conn = ObjConexion.connect(); Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            String pedido = "";
            String columnas="";
            while(resultSet.next()){
                for(int i = 0; i <=numeroColumnas; i++){
                   if( i >= 1){
                        if (resultSet.getString(7).equals("Entregado")){
                        String valorColumna =resultSet.getString(i); // Obtiene valor de la columna 
                        pedido = pedido + valorColumna + ", ";
                        String columna = rsmd.getColumnName(i)+ ":"+ " "+ valorColumna+"  " ;
                        columnas=columnas+columna;
                        }
                   } 
                }
                columnas =columnas+"----------------------------------------------------------------"+"\n";
            } 
        txf_entregados.setText(columnas);
        } catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    

    }

}



