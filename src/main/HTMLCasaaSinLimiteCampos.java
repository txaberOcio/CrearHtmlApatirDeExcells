package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import clases.MedidoresPH;
import clases.objetoSinlimite;

public class HTMLCasaaSinLimiteCampos {

	public static void main(String[] args) {

		String ruta = "C:\\casetes1\\22.xls";
		ArrayList<objetoSinlimite> reg = new ArrayList();
		objetoSinlimite obj = new objetoSinlimite();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ruta);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet hoja = wb.getSheetAt(0);
			Iterator rows = hoja.rowIterator();
			HSSFRow row = (HSSFRow) rows.next();
			int x = 0;
			int u = 0;
			int cont = 0;
			do {
				try {
					obj = new objetoSinlimite();
					try {
						long num = (long) row.getCell(0).getNumericCellValue();

						obj.setUno(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setUno(row.getCell(0).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(1).getNumericCellValue();

						obj.setDos(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setDos(row.getCell(1).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(2).getNumericCellValue();

						obj.setTres(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setTres(row.getCell(2).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(3).getNumericCellValue();

						obj.setCuatro(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setCuatro(row.getCell(3).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(4).getNumericCellValue();

						obj.setCinco(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setCinco(row.getCell(4).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(5).getNumericCellValue();

						obj.setSeis(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setSeis(row.getCell(5).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(6).getNumericCellValue();

						obj.setSiete(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setSiete(row.getCell(6).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(7).getNumericCellValue();

						obj.setOcho(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setOcho(row.getCell(7).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(8).getNumericCellValue();

						obj.setNueve(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setNueve(row.getCell(8).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(9).getNumericCellValue();

						obj.setDiez(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setDiez(row.getCell(9).getStringCellValue());
						} catch (Exception a) {
						}
					}
					try {
						long num = (long) row.getCell(10).getNumericCellValue();

						obj.setOnce(String.valueOf(num));
					} catch (Exception e) {
						try {
							obj.setOnce(row.getCell(10).getStringCellValue());
						} catch (Exception a) {
						}
					}

					row = (HSSFRow) rows.next();
					reg.add(obj);
					cont++;
				} catch (Exception e) {
					e.printStackTrace();
				}
				cont++;
				x++;
			} while (rows.hasNext());

			obj = new objetoSinlimite();
			try {
				long num = (long) row.getCell(0).getNumericCellValue();

				obj.setUno(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setUno(row.getCell(0).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(1).getNumericCellValue();

				obj.setDos(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setDos(row.getCell(1).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(2).getNumericCellValue();

				obj.setTres(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setTres(row.getCell(2).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(3).getNumericCellValue();

				obj.setCuatro(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setCuatro(row.getCell(3).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(4).getNumericCellValue();

				obj.setCinco(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setCinco(row.getCell(4).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(5).getNumericCellValue();

				obj.setSeis(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setSeis(row.getCell(5).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(6).getNumericCellValue();

				obj.setSiete(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setSiete(row.getCell(6).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(7).getNumericCellValue();

				obj.setOcho(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setOcho(row.getCell(7).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(8).getNumericCellValue();

				obj.setNueve(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setNueve(row.getCell(8).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(9).getNumericCellValue();

				obj.setDiez(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setDiez(row.getCell(9).getStringCellValue());
				} catch (Exception a) {
				}
			}
			try {
				long num = (long) row.getCell(10).getNumericCellValue();

				obj.setOnce(String.valueOf(num));
			} catch (Exception e) {
				try {
					obj.setOnce(row.getCell(10).getStringCellValue());
				} catch (Exception a) {
				}
			}

			reg.add(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// System.out.println(listafinal.get(2).getContenido());

//enlace=nombre codigo=codigo descripcion= peso

		System.out.println("|||||||");

		CrearHtml(reg);
	}

	public static void CrearHtml(ArrayList<objetoSinlimite> reg) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		String cod, chapter, subchapter, nombre;

		try {
			fichero = new FileWriter("C:\\Users\\PQNSV2\\Desktop\\Agilent.jsp");
			pw = new PrintWriter(fichero);
			pw.println("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n"
					+ "	pageEncoding=\"UTF-8\" errorPage=\"error.jsp\"\r\n"
					+ "	import=\"java.lang.Float\" import=\"java.text.DecimalFormat\"\r\n"
					+ "	import=\"admin.ParametrosUsuario\" import=\"clases.EstadoAlmacen\"\r\n"
					+ "	import=\"clases.GestionaEmpresas\" import=\"clases.Login\"\r\n"
					+ "	import=\"clases.Imagenes\" import=\"clases.Sesion\"\r\n"
					+ "	import=\"excel.CuentaEspecial\" import=\"excel.LecturaPrecios\"\r\n"
					+ "	import=\"admin.RutasImagenes\" import=\"java.util.LinkedList\"\r\n"
					+ "	import=\"index.*\" import=\"admin.Index\" import=\"buscador.BuscarPrecio\"%>\r\n " + "\r\n"
					+ "<!DOCTYPE HTML>\r\n" + "<html>\r\n" + "\r\n" + "<head>\r\n" + "\r\n"
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
					+ "<!--boostrap-->\r\n" + "<link rel=\"stylesheet\"\r\n"
					+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
					+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
					+ "	crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n"
					+ "	integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<script\r\n"
					+ "	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n"
					+ "	integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<script\r\n"
					+ "	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n"
					+ "	integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<!--mi css-->\r\n" + "<script\r\n"
					+ "	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\r\n"
					+ "<script\r\n"
					+ "	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.0/jquery.cookie.min.js\"></script>\r\n"
					+ "<script\r\n"
					+ "	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\r\n"
					+ "<script src=\"/es/js/cookies.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" charset=\"utf-8\" src=\"/es/js/rotador.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"../../../es/js/codigo.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"../../../es/js/submit.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"../../../es/js/ajustaAlturas.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"../../../es/js/pruebasMenu.js\"></script>\r\n"
					+ "<script src=\"../../../es/Source/jquery.tinycarousel.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"../../../es/js/carrito.js\"></script>\r\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/es/css/estilos.css\">\r\n"
					+ "<script type=\"text/javascript\">\r\n" + "	function clickInicio() {\r\n"
					+ "		temp = \"\";\r\n"
					+ "		if (document.getElementById(\"fs1\").style.display == \"none\") {\r\n"
					+ "			temp = \"block\";\r\n" + "		}\r\n"
					+ "		if (document.getElementById(\"fs1\").style.display == \"block\") {\r\n"
					+ "			temp = \"none\";\r\n" + "		}\r\n"
					+ "		document.getElementById(\"fs1\").style.display = temp;\r\n" + "	}\r\n" + "	\r\n"
					+ "</script>\r\n" + "<script type=\"text/javascript\">\r\n" + "	function muestraAyuda() {\r\n"
					+ "		document.getElementById(\"ayudaBuscador\").style.visibility = \"visible\";\r\n" + "	}\r\n"
					+ "	function ocultaAyuda() {\r\n"
					+ "		document.getElementById(\"ayudaBuscador\").style.visibility = \"hidden\";\r\n" + "	}\r\n"
					+ "</script>\r\n" + "<title>Proquinorte</title>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n"
					+ "		<div class=\"container\">" + "	<div class=\"row\">"
					+ "			<div id=\"panel\" style=\"margin: 0; padding: 0; zindex: 4;\"><%@ include\r\n"
					+ "					file=\"/es/cabecera.jsp\"%></div>\r\n" + "			</div>\r\n </div> \r\n");
			// aqui empiezo a mter mis cosas

			// titulo

			// fin titulo
			// contenido

			// fincontenido
			// tabla
			String anterior = "";

			for (int e = 0; e < reg.size(); e++) {

				if (reg.get(e).getTres().equals("aaa")) {
					if (e % 2 == 0) {
						pw.println("<div class=''>");
					}
					pw.println(
							"<div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12'>");
					pw.println("</div></div></div>");
					pw.println(
							"<div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12'>");
					pw.println("<div class='titulito' >" + reg.get(e).getUno() + "</div>");
					pw.println("</div></div></div>");
					pw.println(
							"<div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8'>");
					pw.println("<div class='textocontenido' >" + reg.get(e).getDos()
							+ "</div></div><div class='col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4'><img width='200px' height='200px' src='fotoproducto/"
							+ reg.get(e + 2).getUno());
					pw.println(".jpg'>");
					pw.println("</div></div></div>");
					pw.println("<table align='center' class='stilosTabla'><tr class='contenido'>");
				} else {
					pw.println("<tr>");

					if (reg.get(e - 1).getTres().equals("aaa")) {
						if (reg.get(e).getDos() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getDos() + "</th>");
						}
						if (reg.get(e).getTres() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getTres() + "</th>");
						}
						if (reg.get(e).getCuatro() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getCuatro() + "</th>");
						}
						if (reg.get(e).getCinco() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getCinco() + "</th>");
						}
						if (reg.get(e).getSeis() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getSeis() + "</th>");
						}
						if (reg.get(e).getSiete() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getSiete() + "</th>");
						}
						if (reg.get(e).getOcho() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getOcho() + "</th>");
						}
						if (reg.get(e).getNueve() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getNueve() + "</th>");
						}
						if (reg.get(e).getDiez() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getDiez() + "</th>");
						}
						if (reg.get(e).getOnce() != null) {
							pw.println("<th class='th1'>" + reg.get(e).getOnce() + "</th>");
						}
						pw.println("<th class='th1'>precio</th>");
						pw.println("<th class='th1'>comprar</th>");
					} else {
						if (reg.get(e).getDos() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getDos() + "</td>");
						}
						if (reg.get(e).getTres() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getTres() + "</td>");
						}
						if (reg.get(e).getCuatro() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getCuatro() + "</td>");
						}
						if (reg.get(e).getCinco() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getCinco() + "</td>");
						}
						if (reg.get(e).getSeis() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getSeis() + "</td>");
						}
						if (reg.get(e).getSiete() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getSiete() + "</td>");
						}
						if (reg.get(e).getOcho() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getOcho() + "</td>");
						}
						if (reg.get(e).getNueve() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getNueve() + "</td>");
						}
						if (reg.get(e).getDiez() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getDiez() + "</td>");
						}
						if (reg.get(e).getOnce() != null) {
							pw.println("<td class='produccel2'>" + reg.get(e).getOnce() + "</td>");
						}
					}
					if (reg.get(e - 1).getTres().equals("aaa")) {
						pw.println("</tr>");
					} else {
						System.out.println(reg.get(e - 1).getTres());
						pw.println("<td class='produccel2'><div id='divCargar" + e + "' name='divCargar" + e
								+ "'> </div>" + "<div id='borrarr" + e
								+ "' class='consultapre' onclick=\"cargarExterno3(`divCargar" + e + "`,'"
								+ reg.get(e).getUno() + "','borrarr" + e + "')\">Consultar precio</div></td>"
								+ "<td class='comprar'><form name='comprar' action='/es/pedido/tramitaPedido.jsp' method='post'>"
								+ "<input type='hidden' name='numLineas' value='1'><input type='hidden' name='linea1' value='"
								+ reg.get(e).getUno() + "'>"
								+ "<input type='number' name='un1' min='1' size='1' class='cantidad'>"
								+ "<input type='image' title='Añadir a cesta' src='/es/imagenes/carro/add.png' class='carrito' onclick='document.comprar.submit()' alt='Add'>"
								+ "</form></td>");
						pw.println("</tr>");
					}

					if (e + 1 < reg.size()) {
						if (reg.get(e + 1).getTres().equals("aaa")) {
							pw.println("</tbody></table></div></div></div></div>");
						}
					}else {
						pw.println("</tbody></table></div></div></div></div>");
					}
					if (e % 2 == 0) {
						pw.println("</div>");
					}
				}
			}
			pw.println("		</div>\r\n" + "			</div>\r\n");
			pw.println("		<div class=\"row\">\r\n" + "			<div class=\"container\">\r\n" +

					"				<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12\">\r\n"
					+ "			<footer>\r\n" + "\r\n"
					+ "					<div id=\"cookie-policy\" class=\"notice hidden\">\r\n"
					+ "						<div class=\"bg\"></div>\r\n"
					+ "						<div class=\"content\">\r\n" + "							<p>\r\n"
					+ "								<a href=\"#\" id=\"dorado\">Informaci&oacuten Legal</a> ||<a\r\n"
					+ "									href=\"#\" id=\"dorado\"> Condiciones Generales</a>\r\n"
					+ "							</p>\r\n" + "\r\n"
					+ "							<p id=\"texto\">www.proquinorte.com - Copyright&copy; 2019 -\r\n"
					+ "								Proquinorte, S.A.</p>\r\n" + "						</div>\r\n"
					+ "					</div>\r\n" + "				</footer>\r\n" + "				</div>\r\n"
					+ "			</div>\r\n" + "		</div></body></html>");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
