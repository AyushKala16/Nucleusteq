import React, { useEffect, useState } from "react";
import {setSeats ,getSeats } from "../services/api";
const OfficerSeatSettings = () => {
    const [seatData, setSeatData] = useState();
    const [inputValues, setInputValues] = useState([]);

    useEffect(() => {
        getAllSeats();
      }, [seatData]);

      const getAllSeats = async () => {
        const seats = await getSeats();
        setSeatData(seats.data);
      }

    const handleInputChange = (index, value) => {
        console.log(value);
        const newValues = [...inputValues];
        newValues[index] = parseInt(value);
        setInputValues(newValues);
    };
    const updateSeats = async (branch, change) => {

        try {
            console.log(branch);
            console.log(change);
            const response = await setSeats(branch,change);
            getAllSeats();
            if (!response.ok) {
                console.error("Failed to update seats on the server");
            }
        } catch (error) {
            console.error("Error updating seats:", error);
        }
    };

    return (
        <div>
            <h2>Officer Seat Settings</h2>
            <table>
                <thead>
                    <tr>
                        <th>Branch</th>
                        <th>Available Seats</th>
                        <th>+/- seats</th>
                        <th>Submit</th>

                    </tr>
                </thead>
                <tbody>
                    {seatData?.map((app, index) => (
                        <tr key={index}>
                            <td>{app.branch}</td>
                            <td>{app.vacantSeats}</td>
                            <td>
                                <input 
                                    type="number" 
                                    value={inputValues[index]} 
                                    onChange={(e) => handleInputChange(index, e.target.value)} 
                                    min="0"
                                />
                            </td>
                            <td>
                                <button onClick={() => updateSeats(app.branch, inputValues
                                    [index]
                                )}>Submit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default OfficerSeatSettings;
