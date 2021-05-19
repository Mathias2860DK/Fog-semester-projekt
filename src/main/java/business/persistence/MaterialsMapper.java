package business.persistence;

import business.entities.Material;
import business.exceptions.UserException;

import java.sql.*;
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
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM fog.roof_types;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String roofType = rs.getString("roof_type");
                    rooftypeList.add(roofType);

                }
                return rooftypeList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Material> getAllMaterials() throws UserException {
        List<Material> materialList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM materials;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //String description, int length, int width, int height, String unit, double price, String materialType, int materialId
                    String description = rs.getString("description");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    String unit = rs.getString("unit");
                    double price = rs.getDouble("price");
                    String materialType = rs.getString("material_type");
                    int materialId = rs.getInt("material_id");

                    Material material = new Material(description, length, width, height, unit, price, materialType, materialId);
                    materialList.add(material);

                }
                return materialList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int deleteMaterial(int materialId) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "DELETE FROM materials WHERE material_id = " + materialId + ";";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                int rowsAffected = ps.executeUpdate();
                return rowsAffected;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

}
