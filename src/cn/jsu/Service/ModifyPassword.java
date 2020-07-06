package cn.jsu.Service;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Vo.User;


/**
 * 修改用户密码
 * @author Black
 *
 */

public class ModifyPassword {
	/**
	 * 这是一个修改密码的方法
	 * @param op	旧密码
	 * @param np	新密码
	 * @param rnp	确定新密码
	 * @param u		用户类
	 */
	public void Modify(String op, String np, String rnp, User u, JFrame frame) throws Exception {
		if(op.equals(u.getPassword())) {
			if(np == null || "".equals(np.trim())) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
			if(np.equals(rnp)) {
				String sql = "update user set password = '"+np+"'"+" where username = '"+u.getUsername()+"'";
				new DatabaseOperateImpl().Update(sql);
				JOptionPane.showMessageDialog(null, "修改成功！");
				frame.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "密码不一致！");
			}
		}else {
			JOptionPane.showMessageDialog(null, "当前密码不一致！");
		}
	}

}
