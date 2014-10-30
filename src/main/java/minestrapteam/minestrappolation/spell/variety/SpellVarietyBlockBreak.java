package minestrapteam.minestrappolation.spell.variety;

import minestrapteam.minestrappolation.entity.EntitySpellProjectile;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.data.SpellCategory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class SpellVarietyBlockBreak extends SpellVariety
{
	public SpellVarietyBlockBreak(int id, String name)
	{
		super(id, SpellCategory.ALTERATION, name);
	}
	
	@Override
	public void cast(Spell spell, EntityPlayer player, World world)
	{
		if (!world.isRemote)
		{
			SpellBlockBreak projectile = new SpellBlockBreak(world, player);
			projectile.setSpell(spell);
			world.spawnEntityInWorld(projectile);
		}
	}
	
	public static class SpellBlockBreak extends EntitySpellProjectile
	{
		public SpellBlockBreak(World world)
		{
			super(world);
		}
		
		public SpellBlockBreak(World world, EntityLivingBase living)
		{
			super(world, living);
		}
		
		@Override
		protected void onImpact(MovingObjectPosition mop)
		{
			if (mop.typeOfHit == MovingObjectType.BLOCK)
			{
				this.worldObj.func_147480_a(mop.blockX, mop.blockY, mop.blockZ, true);
			}
			this.setDead();
		}
	}
}
