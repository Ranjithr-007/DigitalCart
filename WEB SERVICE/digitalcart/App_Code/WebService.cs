using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data;
using MySql.Data;
using MySql.Data.MySqlClient;

/// <summary>
/// Summary description for WebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class WebService : System.Web.Services.WebService
{
    Class1 c = new Class1();
    public WebService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public string HelloWorld()
    {
        return "Hello World";
    }
    [WebMethod]
    public string custreg(string name, string address, string phone, string email, string pass)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "INSERT INTO `customer`(`name`, `address`, `phone`, `email_id`) VALUES ('" + name + "','" + address + "','" + phone + "','" + email + "')";
        c.execute(cmd);
        cmd.CommandText = "select max(cid) from customer";
        int id = c.maxid(cmd);
        MySqlCommand cmd1 = new MySqlCommand();
        cmd1.CommandText = "INSERT INTO `login`(`user_name`, `password`, `type`,`lid`) VALUES ('" + email + "','" + pass + "','customer','" + id + "')";

        try
        {

            c.execute(cmd1);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string addprod(string producttypeid, string productname, string description, string quantity, string price)
    {
        string s = "";
        MySqlCommand cmd2 = new MySqlCommand();
        cmd2.CommandText = "INSERT INTO `product`( `p_id`, `name`, `description`, `price`, `quantity`) VALUES ('" + producttypeid + "','" + productname + "','" + description + "','" + quantity + "','" + price + "')";
        try
        {

            c.execute(cmd2);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }

    [WebMethod]
    public String addtype(string producttype)
    {
        string s = "";
        MySqlCommand cmd3 = new MySqlCommand();
        cmd3.CommandText = "INSERT INTO `product_type`(`product_type`) VALUES ('" + producttype + "')";
        try
        {
            c.execute(cmd3);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;

    }

    [WebMethod]
    public string postcomplaint(string complaint, string userid)
    {
        string s = "";
        MySqlCommand cmd4 = new MySqlCommand();
        cmd4.CommandText = "INSERT INTO `complaint_and_give_reply`( `v_id`, `complaint`, `date`, `reply`) VALUES ('" + userid + "','" + complaint + "','" + System.DateTime.Now.ToShortDateString() + "','pending')";
        try
        {
            c.execute(cmd4);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string postfeedback(string feedback, string userid)
    {
        string s = "";
        MySqlCommand cmd5 = new MySqlCommand();
        cmd5.CommandText = "INSERT INTO `feedback`(`v_id`, `feedback`, `date`) VALUES ('" + userid + "','" + feedback + "','" + System.DateTime.Now.ToShortDateString() + "')";
        try
        {
            c.execute(cmd5);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string stockupdate( string quantity,string pid)
    {
        string s = "";
        MySqlCommand cmd6 = new MySqlCommand();
        cmd6.CommandText = "UPDATE `product` SET `quantity`='" + quantity + "' WHERE  pr_id='" + pid + "'";
        try
        {
            c.execute(cmd6);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;

    }

    [WebMethod]
    public String v_feedback()
    {
        string s = "";
        MySqlCommand cmd7 = new MySqlCommand();
        cmd7.CommandText = "SELECT c.name,f.feedback,f.date from customer c,feedback f where f.v_id=c.cid ";
        DataTable dt = c.getdata(cmd7);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() +  "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string v_stock()
    {
        string s = "";
        MySqlCommand cmd8 = new MySqlCommand();
        cmd8.CommandText = "SELECT `pr_id`, `p_id`, `name`, `description`, `price`, `quantity` FROM `product`";
        DataTable dt = c.getdata(cmd8);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[1].ToString() + "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }
    //[WebMethod]
    //public string v_cart()
    //{
    //    string s = "";
    //    MySqlCommand cmd9 = new MySqlCommand();
    //    cmd9.CommandText = "SELECT `sid`, `name`, `gender`, `address`, `phone`, `mail`, `password` FROM `staff` ";
    //    DataTable dt = c.getdata(cmd9);
    //    if (dt.Rows.Count > 0)
    //    {
    //        foreach (DataRow dr in dt.Rows)
    //        {
    //            s += dr[0].ToString() + "#" + dr[1].ToString() + "@";
    //        }
    //    }
    //    else
    //    {
    //        s = "error";
    //    }
    //    return s;
    //}
    [WebMethod]
    public string v_reply(string uid)
    {
        string s = "";
        MySqlCommand cmd9 = new MySqlCommand();
        cmd9.CommandText = "SELECT `id`, `complaint`, `date`, `reply` FROM `complaint_and_give_reply` where v_id='" + uid + "'";
        DataTable dt = c.getdata(cmd9);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;

    }
    [WebMethod]
    public string v_products(string type)
    {
        string s = "";
        MySqlCommand cmd10 = new MySqlCommand();
        cmd10.CommandText = "SELECT   * FROM `product` WHERE p_id='"+type+"'";
        DataTable dt = c.getdata(cmd10);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "#" + dr[4].ToString() + "#" + dr[5].ToString() + "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }

    [WebMethod]
    public string v_billreport(string tid)
    {
        string s = "";
        MySqlCommand cmd11 = new MySqlCommand();
        cmd11.CommandText = "SELECT p.name,p.price,b.date,b.time from bill_details b,product p where p.pr_id=b.pr_id and b.trolley_id='"+tid+"'";
        DataTable dt = c.getdata(cmd11);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }



    [WebMethod]
    public string get_trollyid(string tno)
    {
        string s = "";
        MySqlCommand cmd11 = new MySqlCommand();
        cmd11.CommandText = "select * from trolley_registration where trolley_no='"+tno+"'";
        DataTable dt = c.getdata(cmd11);
        if (dt.Rows.Count > 0)
        {
            s = dt.Rows[0][0].ToString();
        }
        else
        {
            s = "error";
        }
        return s;
    }


    [WebMethod]
    public string login(string unm, string pass)
    {
        string s = "";
        MySqlCommand cmd11 = new MySqlCommand();
        cmd11.CommandText = "select * from login where user_name='" + unm + "'and password='" + pass + "'";
        DataTable dt = c.getdata(cmd11);
        if (dt.Rows.Count > 0)
        {
            s = dt.Rows[0][0].ToString() + "#" + dt.Rows[0][3].ToString();
        }
        else
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public String salesreport(string no_of_purchase, string profit, string date, string loss)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "INSERT INTO `sales_report`( `number_of_purchase`, `profit`, `date`, `loss`) VALUES ('" + no_of_purchase + "','" + profit + "','" + date + "','" + loss + "')";
        try
        {
            c.execute(cmd);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string v_producttype()
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "SELECT `p_id`, `product_type` FROM `product_type` ";
        DataTable dt = c.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[1].ToString() + "@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string product_type(string type)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "SELECT   `pr_id` ,`name`,`quantity` FROM `product` WHERE p_id='"+type+"'";
        DataTable dt = c.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {
                s += dr[0].ToString() + "#" + dr[1].ToString() + "#"+dr[2].ToString()+"@";
            }
        }
        else
        {
            s = "error";
        }
        return s;
    }
}


