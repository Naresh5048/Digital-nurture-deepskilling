import React, { Component } from 'react';

export class Cart extends Component {
  render() {
    return (
      <table 
        border="1" 
        style={{ 
          margin: '0 auto', 
          borderCollapse: 'collapse', 
          color: 'green',
          width: '300px',
          textAlign: 'center' 
        }}
      >
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {this.props.item.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.itemname}</td>
                <td>{item.price}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    );
  }
}

export default Cart;