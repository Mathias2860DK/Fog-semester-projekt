package business.persistence;

import business.entities.Material;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialsMapper {
    private static Database database;

    public MaterialsMapper(Database database) {
        this.database = database;
    }

//rooftype er bare en string. ku evt laves om til et object
    public static List<String> getAllRoofTypes() throws UserException {
        List<String> rooftypeList = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM fog.roof_types;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                   String roofType = rs.getString("roof_type");
                   rooftypeList.add(roofType);

                }
                return rooftypeList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public static List<Material> getAllMaterials() throws UserException {
        List<Material> materialList = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM materials;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                   String description = rs.getString("description");


                }
                return materialList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
}
