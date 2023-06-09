package main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.BaseDeDatos;
import clases.Reactivos;
import clases.Conexion;
public class consulta {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
	Reactivos obj=new Reactivos();
	String codigo,nombre,cas="0";
	ArrayList <Reactivos> lista=new ArrayList<Reactivos>();
	try {
	Conexion conexionBBDD = BaseDeDatos.getParametros();
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conexionGet = DriverManager.getConnection(conexionBBDD.getServidor()+"user="+conexionBBDD.getUser()+";password="+conexionBBDD.getPass()+";");
	//PreparedStatement ps = conexionGet.prepareStatement("SELECT DISTINCT a.codigo FROM articulo a INNER JOIN pvp p ON p.articulo=a.codigo WHERE p.pvp >? AND a.internet=? AND upper(a.codigo) LIKE ?");
	//PreparedStatement ps = conexionGet.prepareStatement("SELECT pvp from dbo.pvp where tarifa='TN' and articulo like '%"+producto+"%'");
	PreparedStatement ps = conexionGet.prepareStatement("SELECT a. a.CODIGO, a.NOMBRE, b.VALOR FROM [dbo].[articulo] a left JOIN [dbo].[multicam] b on a.CODIGO=b.CODIGO WHERE FAMILIA LIKE '000002' AND b.CAMPO='CAS'");
//SELECT [CODIGO],[NOMBRE],[ABREV],[FAMILIA],[MARCA] FROM [2020NO].[dbo].[articulo] WHERE FAMILIA LIKE '000002'
	//SELECT TOP (1000) [FICHERO],[CODIGO],[CAMPO],[VALOR],[VISTA],[GUID_ID],[CREATED],[MODIFIED] FROM [2020NO].[dbo].[multicam]WHERE CAMPO = 'CAS' AND VALOR != ''
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
	
	codigo=rs.getString(1);
	nombre=rs.getString(2);
	cas=rs.getString(3);
	System.out.println(codigo+"///"+nombre.trim()+"///"+cas);
	obj= new Reactivos(nombre,codigo,cas);
	lista.add(obj);
	
	};/*
	for(int i=0;i<lista.size();i++) {
		System.out.println(lista.get(i).getCodigo()+" "+lista.get(i).getNombre()+" "+lista.get(i).getCas());
		
	}*/System.out.println(lista.size());
	}catch(Exception e){
		e.printStackTrace();
	}
	
		
	}
	

}
